import {Component, OnInit} from '@angular/core';
import {Service} from "../../../model/service/Service";
import {ServiceService} from "../../../service/service.service";
import {MatDialog} from "@angular/material/dialog";
import {EditServiceComponent} from "../edit-service/edit-service.component";
import {DeleteServiceComponent} from "../delete-service/delete-service.component";

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {

  listService: Array<Service>;

  constructor(
    private serviceService: ServiceService,
    private dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.updateList()
  }

  updateList() {
    this.serviceService.getAllServices().subscribe(
      data => this.listService = data
    )
  }

  editDialog(id: number) {
    this.serviceService.getServiceById(id).subscribe(
      data => this.dialog.open(EditServiceComponent, {
        width: '700px',
        height: '750px',
        data: data
      }).afterClosed().subscribe(() => this.updateList())
    )
  }

  deleteDialog(id: number) {
    this.serviceService.getServiceById(id).subscribe(
      data => this.dialog.open(DeleteServiceComponent, {
        height: "180px",
        width: "400px",
        data: data
      }).afterClosed().subscribe(() => this.updateList())
    )
  }
}
