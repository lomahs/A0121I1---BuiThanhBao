import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../service/employee/employee.service";
import {Employee} from "../../../model/employee/Employee";
import {MatDialog} from "@angular/material/dialog";
import {DeleteEmployeeComponent} from "../delete-employee/delete-employee.component";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  listEmployees: Array<Employee> = [];
  curPage: number;

  constructor(
    private employeeService: EmployeeService,
    private dialog: MatDialog
  ) {
  }

  ngOnInit(): void {
    this.updateList();
  }

  updateList() {
    this.employeeService.getAllEmployees().subscribe(
      data => this.listEmployees = data
    )
  }

  openDialogConfirm(id: number) {
    this.employeeService.getEmployeeById(id).subscribe(
      data => this.dialog.open(DeleteEmployeeComponent, {
        height: "180px",
        width: "400px",
        data: data
      }).afterClosed().subscribe(() => this.updateList())
    )
  }

  searchByName(value: string) {
    if (value) {
      this.employeeService.getListEmployeeByName(value).subscribe(
        data => this.listEmployees = data
      )
    } else {
      this.updateList();
    }
    this.curPage = 1;
  }
}
