import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../../model/customer/Customer";
import {CustomerType} from "../../model/customer/CustomerType";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  readonly api: string = "http://localhost:3000/customer";
  readonly apiCustomerType: string = "http://localhost:3000/customerType"

  constructor(private http: HttpClient) {
  }

  getAllCustomers(): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(this.api);
  }

  addCustomer(customer: Customer) {
    return this.http.post(this.api, customer);
  }

  getAllCustomerTypes(): Observable<Array<CustomerType>> {
    return this.http.get<Array<CustomerType>>(this.apiCustomerType);
  }

  editCustomer(customer: Customer) {
    return this.http.put(this.api + "/" + customer.id, customer);
  }

  getCustomerById(id: any): Observable<Customer> {
    return this.http.get<Customer>(this.api + "/" + id);
  }

  deleteCustomerById(id: any) {
    return this.http.delete(this.api + "/" + id);
  }

  sortListByName(orderSort: boolean): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(`${this.api}?_sort=name&_order=${orderSort ? 'asc' : 'desc'}`);
  }

  getListCustomerByName(name: string): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>(this.api + "?name_like=" + name);
  }
}
