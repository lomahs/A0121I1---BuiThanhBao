import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../../model/employee/Employee";
import {EducationDegree} from "../../model/employee/EducationDegree";
import {Position} from "../../model/employee/Position";
import {Division} from "../../model/employee/Division";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  readonly api: string = "http://localhost:3000/employee";
  readonly api_educationDegree: string = "http://localhost:3000/educationDegree";
  readonly api_division: string = "http://localhost:3000/division";
  readonly api_position: string = "http://localhost:3000/position";

  constructor(
    private http: HttpClient
  ) {
  }

  getAllEmployees(): Observable<Array<Employee>> {
    return this.http.get<Array<Employee>>(this.api);
  }

  getAllEducationDegree(): Observable<Array<EducationDegree>> {
    return this.http.get<Array<EducationDegree>>(this.api_educationDegree);
  }

  getAllPosition(): Observable<Array<Position>> {
    return this.http.get<Array<Position>>(this.api_position);
  }

  getAllDivision(): Observable<Array<Division>> {
    return this.http.get<Array<Division>>(this.api_division);
  }

  addEmployee(employee: Employee) {
    return this.http.post(this.api, employee);
  }

  getEmployeeById(id: any): Observable<Employee> {
    return this.http.get<Employee>(this.api + "/" + id);
  }

  deleteEmployeeById(id: any) {
    return this.http.delete(this.api + "/" + id);
  }

  editEmployee(employee: Employee) {
    return this.http.put(this.api + "/" + employee.id, employee);
  }

  sortListByName(orderSort: boolean): Observable<Array<Employee>> {
    return this.http.get<Array<Employee>>(`${this.api}?_sort=name&_order=${orderSort ? 'asc' : 'desc'}`);
  }

  getListEmployeeByName(name: string): Observable<Array<Employee>> {
    return this.http.get<Array<Employee>>(this.api + "?name_like=" + name);
  }
}
