import {Component, OnInit} from '@angular/core';
import {Showtime} from "../showtime";
import {ShowtimeService} from "../showtime.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteShowtimeComponent} from "../delete-showtime/delete-showtime.component";

@Component({
  selector: 'app-list-showtime',
  templateUrl: './list-showtime.component.html',
  styleUrls: ['./list-showtime.component.css']
})
export class ListShowtimeComponent implements OnInit {

  listShowtime: Array<Showtime> = [];

  constructor(
    private service: ShowtimeService,
    private dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.updateList();
  }

  updateList() {
    this.service.getAllShowtime().subscribe(
      data => this.listShowtime = data
    )
  }

  openDeleteConfirmDialog(id: number) {
    this.service.getShowtimeById(id).subscribe(
      data => this.dialog.open(DeleteShowtimeComponent, {
        height: "220px",
        width: "400px",
        data: data
      }).afterClosed().subscribe(() => this.updateList())
    )
  }
}
