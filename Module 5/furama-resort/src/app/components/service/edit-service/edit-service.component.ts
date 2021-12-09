import {Component, Inject, OnInit} from '@angular/core';
import {RentType} from "../../../model/service/RentType";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ServiceService} from "../../../service/service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {

  listRentType: Array<RentType> = new Array<RentType>();
  formEditService: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private serviceService: ServiceService,
    private router: Router,
    private snackBar: MatSnackBar,
    private activatedRoute: ActivatedRoute,
    private dialogRef: MatDialogRef<EditServiceComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any
  ) {
    this.createForm();
  }


  ngOnInit(): void {
    this.serviceService.getAllRentTypes().subscribe(
      data => {
        this.listRentType = data;
        setTimeout(() => this.formEditService.setValue(this.data), 50)
      },
    )
  }

  createForm() {
    this.formEditService = this.formBuilder.group({
      name: ['', Validators.required],
      area: ['', [Validators.required, Validators.min(1)]],
      numberOfFloors: ['', [Validators.required, Validators.min(1)]],
      maxPeople: ['', [Validators.required, Validators.min(1)]],
      cost: ['', [Validators.required, Validators.min(0)]],
      rentType: ['', Validators.required],
      status: ['', Validators.required],
      id: []
    })
  }

  confirmEditCustomer() {
    if (this.formEditService.valid) {
      this.serviceService.editService(this.formEditService.value).subscribe(
        () => {
          this.dialogRef.close();
          this.snackBar.open("Edit Successful")._dismissAfter(3000)
        }
      )
    }
  }
}
