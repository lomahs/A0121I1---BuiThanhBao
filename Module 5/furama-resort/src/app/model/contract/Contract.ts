import {Employee} from "../employee/Employee";
import {Customer} from "../customer/Customer";
import {Service} from "../service/Service";

export interface Contract{
  id: number;
  employee: Employee,
  customer: Customer,
  service: Service,
  dateCreate: Date,
  dateEnded: Date,
  deposit: number,
  totalMoney: number,
}
