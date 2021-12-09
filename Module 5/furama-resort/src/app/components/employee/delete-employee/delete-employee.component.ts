import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";
import {EmployeeService} from "../../../service/employee/employee.service";

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {

  employee: any;

  constructor(
    private employeeService: EmployeeService,
    private dialogRef: MatDialogRef<DeleteEmployeeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.employee = this.data;
  }

  confirmDeleteEmployee() {
    this.employeeService.deleteEmployeeById(this.employee.id).subscribe(
      () => {
        this.dialogRef.close();
        this.snackBar.open("Delete Successful")._dismissAfter(3000)
      }
    )
  }
}
