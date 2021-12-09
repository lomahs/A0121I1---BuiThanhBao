import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../../model/customer/CustomerType";
import {CustomerService} from "../../../service/customer/customer.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-form-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})


export class AddCustomerComponent implements OnInit {

  listCustomerType: Array<CustomerType> = [];

  formAddCustomer: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.createForm();
    this.customerService.getAllCustomerTypes().subscribe(
      data => this.listCustomerType = data
    )
  }

  createForm() {
    this.formAddCustomer = this.formBuilder.group({
      type: ['', [Validators.required]],
      name: ['', [Validators.required]],
      birthday: ['', [Validators.required, this.isBeforeToday]],
      idCard: ['', [Validators.required, Validators.pattern("(\\d{3} ){2,3}\\d{3}")]],
      phone: ['', [Validators.required, Validators.pattern("^(090|091) \\d{3} \\d{4}$")]],
      email: ['', [Validators.email, Validators.required]],
      address: ['', [Validators.required]]
    })
  }

  isBeforeToday(date: AbstractControl) {
    if (new Date(date.value) > new Date()) {
      return {'invalidAge': true}
    }
    return null;
  }

  addCustomer() {
    if (this.formAddCustomer.valid) {
      this.customerService.addCustomer(this.formAddCustomer.value).subscribe(
        () => {
          this.router.navigateByUrl("customer").then(() => this.snackBar.open("Add successful")._dismissAfter(3000))
        }
      );
    }
  }
}
