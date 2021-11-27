import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {listStudent} from "../model/studentDAO";

@Component({
  selector: 'app-student-add-form',
  templateUrl: './student-add-form.component.html',
  styleUrls: ['./student-add-form.component.css']
})
export class StudentAddFormComponent implements OnInit {

  // @ts-ignore
  addForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.addForm = this.fb.group({
      id: ['', [Validators.required]],
      name: ['', [Validators.required]],
      age: ['', [Validators.required]],
      mark: ['', [Validators.required, Validators.min(0), Validators.max(10)]]
    })
  }

  ngOnInit(): void {

  }

  addStudent() {
    listStudent.unshift(this.addForm.value);
  }
}
