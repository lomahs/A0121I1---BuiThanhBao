import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {ShowtimeService} from "../showtime.service";
import {ActivatedRoute} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Showtime} from "../showtime";

@Component({
  selector: 'app-delete-showtime',
  templateUrl: './delete-showtime.component.html',
  styleUrls: ['./delete-showtime.component.css']
})
export class DeleteShowtimeComponent implements OnInit {

  // @ts-ignore
  showtime: Showtime;

  constructor(
    private dialogRef: MatDialogRef<DeleteShowtimeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private service: ShowtimeService,
    private activatedRoute: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.showtime = this.data;
  }

  confirmDeleteShowtime() {
    this.service.deleteShowtimeById(this.showtime.id).subscribe(
      () => {
        this.dialogRef.close();
        this.snackBar.open("Delete Successful")._dismissAfter(3000)
      }
    )
  }
}
