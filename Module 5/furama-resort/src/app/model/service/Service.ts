import {RentType} from "./RentType";

export interface Service {
  id: number,
  name: string,
  area: number,
  numberOfFloors: number,
  maxPeople: number,
  cost: number,
  rentType: RentType,
  status: string
}
