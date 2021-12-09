import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../../service/customer/customer.service";
import {ServiceService} from "../../../service/service.service";
import {Employee} from "../../../model/employee/Employee";
import {Customer} from "../../../model/customer/Customer";
import {Service} from "../../../model/service/Service";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ContractService} from "../../../service/contract.service";
import {EmployeeService} from "../../../service/employee/employee.service";

@Component({
  selector: 'app-form-add-contract',
  templateUrl: './form-add-contract.component.html',
  styleUrls: ['./form-add-contract.component.css']
})
export class FormAddContractComponent implements OnInit {

  listEmployees: Array<Employee>;
  listCustomers: Array<Customer>;
  listServices: Array<Service>;

  formAddService: FormGroup = this.formBuilder.group({
    employee: ['', Validators.required],
    customer: ['', Validators.required],
    service: ['', Validators.required],
    dateCreate: ['', [Validators.required, this.isBeforeToday]],
    dateEnded: ['', [Validators.required]],
    deposit: ['', [Validators.required, Validators.min(0)]],
  }, {validators: this.isValidDuration})

  constructor(
    private employeeService: EmployeeService,
    private customerService: CustomerService,
    private serviceService: ServiceService,
    private contractService: ContractService,
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {

    this.employeeService.getAllEmployees().subscribe(
      data => this.listEmployees = data
    )

    this.customerService.getAllCustomers().subscribe(
      data => this.listCustomers = data
    )

    this.serviceService.getAllServices().subscribe(
      data => this.listServices = data
    )
  }


  addContract() {
    if (this.formAddService.valid) {
      this.contractService.addContract(this.formAddService.value).subscribe();
    }
  }


  isValidDuration(group: AbstractControl) {
    const startDate = group.get('dateCreate')?.value;
    const endDate = group.get('dateEnded')?.value;

    if (new Date(startDate) > new Date(endDate)) {
      return {'invalidDate': true}
    }
    return null;
  }

  isBeforeToday(date: AbstractControl) {
    if (!(new Date(date.value) > new Date())) {
      return {'beforeToday': true}
    }
    return null;
  }
}
