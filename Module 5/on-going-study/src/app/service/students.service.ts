import { Injectable } from '@angular/core';
import {listStudent} from "../model/studentDAO";
import {Student} from "../model/student";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor() { }

  students: Array<Student> = listStudent;

  getAllStudents(): Array<Student>{
    return this.students;
  }

  addStudent(student: Student): void{
    this.students.push(student);
  }

  getStudentById(id: any){
   return this.students.find(student => student.id == id);
  }
}
