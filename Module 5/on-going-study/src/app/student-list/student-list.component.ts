import {Component, OnInit} from '@angular/core';
import {listStudent} from "../model/studentDAO";
import {Student} from "../model/student";
import {HttpClient} from "@angular/common/http";
import {StudentsService} from "../service/students.service";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  listStudents : Array<Student> | undefined;

  constructor(private studentsService: StudentsService) {
  }

  ngOnInit(): void {
    this.listStudents = this.studentsService.getAllStudents();
  }

}
