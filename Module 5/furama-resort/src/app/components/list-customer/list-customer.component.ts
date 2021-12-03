import {Component, OnInit} from '@angular/core';
import {Customer} from "../../model/customer/Customer";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})

export class ListCustomerComponent implements OnInit {

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  listCustomer: Array<Customer> = [
    {
      id: 1,
      name: "Thanh Bao",
      type: {
        id: 1,
        name: "Diamond"
      },
      address: "Quang Nam",
      birthday: new Date("1999-10-05"),
      email: "bao@gmail.com",
      idCard: "123123123",
      phone: "012345678"
    },
    {
      id: 2,
      name: "Duy Phu",
      type: {
        id: 2,
        name: "Gold"
      },
      address: "Quang Nam",
      birthday: new Date("2000-11-05"),
      email: "phu@gmail.com",
      idCard: "111111222",
      phone: "312412312"
    },
    {
      id: 2,
      name: "Ngoc Tuan",
      type: {
        id: 3,
        name: "Silver"
      },
      address: "Da Nang",
      birthday: new Date("1999-07-30"),
      email: "tuan@gmail.com",
      idCard: "123123123",
      phone: "012345678"
    },
    {
      id: 4,
      name: "Tung Anh",
      type: {
        id: 1,
        name: "Diamond"
      },
      address: "Quang Nam",
      birthday: new Date("1999-10-05"),
      email: "anh@gmail.com",
      idCard: "123123123",
      phone: "012345678"
    }
  ];

  listOrderedCustomer = this.listCustomer;


}
