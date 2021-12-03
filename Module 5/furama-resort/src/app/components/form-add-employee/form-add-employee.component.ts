import {Component, OnInit} from '@angular/core';
import {Division} from "../../model/employee/Division";
import {Position} from "../../model/employee/Position";
import {EducationDegree} from "../../model/employee/EducationDegree";
import {FormBuilder, FormGroup} from "@angular/forms";

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

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.createForm()
  }

  createForm() {
    this.formAddEmployee = this.formBuilder.group({
      name: [],
      position: [],
      educationDegree: [],
      division: [],
      birthday: [],
      idCard: [],
      salary: [],
      phone: [],
      email: [],
      address: []
    })
  }

  addEmployee() {

  }
}
