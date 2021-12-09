import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer/Customer";
import {CustomerService} from "../../../service/customer/customer.service";
import {MatDialog} from "@angular/material/dialog";
import {DeleteCustomerComponent} from "../delete-customer/delete-customer.component";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})

export class ListCustomerComponent implements OnInit {

  listCustomer: Array<Customer> = [];
  curPage: number | string;

  constructor(
    private customerService: CustomerService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.updatedList();
  }

  updatedList() {
    this.customerService.getAllCustomers().subscribe(
      data => this.listCustomer = data
    )
  }

  openDeleteConfirm(id: number) {
    this.customerService.getCustomerById(id).subscribe(
      cus => this.dialog.open(DeleteCustomerComponent, {
        height: "180px",
        width: "400px",
        data: cus
      }).afterClosed().subscribe(() => this.updatedList())
    )
  }

  orderSort: boolean = false;

  sortByName() {
    this.orderSort = !this.orderSort;
    this.customerService.sortListByName(this.orderSort).subscribe(
      data => this.listCustomer = data
    )
  }

  searchByName(name: string) {
    if (name) {
      this.customerService.getListCustomerByName(name).subscribe(
        data => this.listCustomer = data
      )
    } else {
      this.updatedList();
    }
    this.curPage = 1;
  }
}
