import {Component, OnInit} from '@angular/core';
import {Student} from "../model/student";
import {StudentsService} from "../service/students.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  student: any;

  constructor(private studentsService: StudentsService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    let id;
    this.activatedRoute.paramMap.subscribe(
      (paramMap) => {
        id = paramMap.get('id');
        this.student = this.studentsService.getStudentById(id);
      }
    )
    //
    // id = this.activatedRoute.snapshot.params["id"];
    // this.student = this.studentsService.getStudentById(id);
  }

  result: string = '';
  getResult() {
    if (this.student.mark < 5){
      this.result = "FAILED"
    }else {
      this.result = "PASSED"
    }
  }
}
