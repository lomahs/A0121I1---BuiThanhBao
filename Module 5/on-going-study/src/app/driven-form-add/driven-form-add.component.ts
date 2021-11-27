import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {listStudent} from "../model/studentDAO";

@Component({
  selector: 'app-driven-form-add',
  templateUrl: './driven-form-add.component.html',
  styleUrls: ['./driven-form-add.component.css']
})
export class DrivenFormAddComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  addStudent(addForm: NgForm) {
    listStudent.unshift(addForm.value);
  }
}
