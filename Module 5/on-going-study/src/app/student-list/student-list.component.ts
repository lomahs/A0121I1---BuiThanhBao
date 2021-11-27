import {Component, OnInit} from '@angular/core';
import {listStudent} from "../model/studentDAO";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  listStudents = listStudent;


}
