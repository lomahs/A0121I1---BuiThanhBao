import {Component, OnInit} from '@angular/core';
import {RentType} from "../../../model/service/RentType";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ServiceService} from "../../../service/service.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-form-add-service',
  templateUrl: './form-add-service.component.html',
  styleUrls: ['./form-add-service.component.css']
})
export class FormAddServiceComponent implements OnInit {

  listRentType: Array<RentType> = new Array<RentType>();
  formAddService: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private serviceService: ServiceService,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
  }

  ngOnInit(): void {
    this.createForm();
    this.serviceService.getAllRentTypes().subscribe(
      data => this.listRentType = data
    )
  }

  createForm() {
    this.formAddService = this.formBuilder.group({
      name: ['', Validators.required],
      area: ['', [Validators.required, Validators.min(1)]],
      numberOfFloors: ['', [Validators.required, Validators.min(1)]],
      maxPeople: ['', [Validators.required, Validators.min(1)]],
      cost: ['', [Validators.required, Validators.min(0)]],
      rentType: ['', Validators.required],
      status: ['', Validators.required]
    })
  }


  addService() {
    if (this.formAddService.valid) {
      this.serviceService.addService(this.formAddService.value).subscribe(
        () => this.router.navigateByUrl("service").then(() => this.snackBar.open("Add Successful")._dismissAfter(3000))
      );
    }
  }
}
