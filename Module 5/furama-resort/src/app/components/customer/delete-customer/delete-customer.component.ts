import {Component, Inject, OnInit} from '@angular/core';
import {CustomerService} from "../../../service/customer/customer.service";
import {ActivatedRoute} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {

  customer: any;

  constructor(
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private dialogRef: MatDialogRef<DeleteCustomerComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.customer = this.data;
  }

  confirmDeleteCustomer() {
    this.customerService.deleteCustomerById(this.customer.id).subscribe(
      () => {
        this.dialogRef.close();
        this.snackBar.open("Delete Successful")._dismissAfter(3000)
      }
    )
  }
}
