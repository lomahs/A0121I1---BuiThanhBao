import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerType} from "../../model/customer/CustomerType";

@Component({
  selector: 'app-form-add-customer',
  templateUrl: './form-add-customer.component.html',
  styleUrls: ['./form-add-customer.component.css']
})


export class FormAddCustomerComponent implements OnInit {

  type1: CustomerType = {
    id: 1,
    name: "Diamond"
  }

  type2: CustomerType = {
    id: 2,
    name: "Gold"
  }

  type3: CustomerType = {
    id: 3,
    name: "Silver"
  }

  listCustomerType: Array<CustomerType> = [this.type1, this.type2, this.type3];

  formAddCustomer: FormGroup;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.formAddCustomer = this.formBuilder.group({
      type: [],
      name: [''],
      birthday: [''],
      idCard: [''],
      phone: [''],
      email: [''],
      address: ['']
    })
  }

  addCustomer() {
    console.log(this.formAddCustomer.value.type)
  }
}
