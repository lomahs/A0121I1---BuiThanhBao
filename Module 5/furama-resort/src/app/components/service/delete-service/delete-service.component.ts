import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ServiceService} from "../../../service/service.service";

@Component({
  selector: 'app-delete-service',
  templateUrl: './delete-service.component.html',
  styleUrls: ['./delete-service.component.css']
})
export class DeleteServiceComponent implements OnInit {

  service: any;

  constructor(
    private serviceService: ServiceService,
    private dialogRef: MatDialogRef<DeleteServiceComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.service = this.data;
  }

  confirmDeleteService() {
    this.serviceService.deleteServiceById(this.service.id).subscribe(
      () => {
        this.dialogRef.close();
        this.snackBar.open("Delete Successful")._dismissAfter(3000)
      }
    )
  }
}
