import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../../model/customer/CustomerType";
import {CustomerService} from "../../../service/customer/customer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  listCustomerType: Array<CustomerType> = [];

  formEditCustomer: FormGroup = this.formBuilder.group({
    type: ['', [Validators.required]],
    name: ['', [Validators.required]],
    birthday: ['', [Validators.required, this.isBeforeToday]],
    idCard: ['', [Validators.required, Validators.pattern("(\\d{3} ){2,3}\\d{3}")]],
    phone: ['', [Validators.required, Validators.pattern("^(090|091) \\d{3} \\d{4}$")]],
    email: ['', [Validators.email, Validators.required]],
    address: ['', [Validators.required]],
    id: []
  });

  constructor(
    private formBuilder: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerTypes().subscribe(
      data => {
        this.listCustomerType = data;

        let id = this.activatedRoute.snapshot.params['id'];
        this.customerService.getCustomerById(id).subscribe(
          data1 => {
            this.formEditCustomer.setValue(data1)
          }
        )
      }
    );
  }

  editCustomer() {
    if (this.formEditCustomer.valid) {
      this.customerService.editCustomer(this.formEditCustomer.value).subscribe(
        () => {
          this.router.navigateByUrl("customer").then(() => this.snackBar.open("Edit successful")._dismissAfter(3000))
        }
      );
    }
  }

  isBeforeToday(date: AbstractControl) {
    if (new Date(date.value) > new Date()) {
      return {'invalidAge': true}
    }
    return null;
  }

}
