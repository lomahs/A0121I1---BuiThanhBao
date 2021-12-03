import {Position} from "./Position";
import {EducationDegree} from "./EducationDegree";
import {Division} from "./Division";

export interface Employee{
  id: number,
  name: string,
  position: Position,
  educationDegree: EducationDegree,
  division: Division,
  birthday: Date,
  idCard: string,
  salary: number,
  phone: string,
  email: string,
  address: string
}
