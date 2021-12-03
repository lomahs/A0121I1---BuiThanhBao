import {CustomerType} from "./CustomerType";

export interface Customer {
  id: number,
  type: CustomerType,
  name: string,
  birthday: Date,
  idCard: string,
  phone: string,
  email: string,
  address: string
}
