import {Component, OnInit} from '@angular/core';
import {Division} from "../../../model/employee/Division";
import {Position} from "../../../model/employee/Position";
import {EducationDegree} from "../../../model/employee/EducationDegree";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../service/employee/employee.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-form-add-employee',
  templateUrl: './form-add-employee.component.html',
  styleUrls: ['./form-add-employee.component.css']
})
export class FormAddEmployeeComponent implements OnInit {

  listDivision: Array<Division> = new Array<Division>();
  listPosition: Array<Position> = new Array<Position>();
  listEducationDegree: Array<EducationDegree> = new Array<EducationDegree>();

  formAddEmployee: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private employeeService: EmployeeService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.createForm()
    this.employeeService.getAllEducationDegree().subscribe(
      data => this.listEducationDegree = data
    );
    this.employeeService.getAllPosition().subscribe(
      data => this.listPosition = data
    );
    this.employeeService.getAllDivision().subscribe(
      data => this.listDivision = data
    )
  }

  createForm() {
    this.formAddEmployee = this.formBuilder.group({
      name: ['', [Validators.required]],
      position: ['', [Validators.required]],
      educationDegree: ['', Validators.required],
      division: ['', Validators.required],
      birthday: ['', [Validators.required, this.isBeforeToday]],
      idCard: ['', [Validators.required, Validators.pattern("(\\d{3} ){2,3}\\d{3}")]],
      salary: [0, [Validators.required, Validators.min(0)]],
      phone: ['', [Validators.required, Validators.pattern("^(090|091) \\d{3} \\d{4}$")]],
      email: ['', [Validators.email, Validators.required]],
      address: ['', Validators.required]
    })
  }

  addEmployee() {
    if (this.formAddEmployee.valid) {
      this.employeeService.addEmployee(this.formAddEmployee.value).subscribe(
        () => this.router.navigateByUrl("employee").then(
          () => this.snackBar.open("Add successful")._dismissAfter(3000)
        )
      );
    }
  }

  isBeforeToday(date: AbstractControl) {
    if (new Date(date.value) > new Date()) {
      return {'invalidAge': true}
    }
    return null;
  }
}
