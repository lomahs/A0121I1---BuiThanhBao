import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {ListCustomerComponent} from "../components/customer/list-customer/list-customer.component";
import {AddCustomerComponent} from "../components/customer/add-customer/add-customer.component";
import {ListEmployeeComponent} from "../components/employee/list-employee/list-employee.component";
import {FormAddEmployeeComponent} from "../components/employee/form-add-employee/form-add-employee.component";
import {ListServiceComponent} from "../components/service/list-service/list-service.component";
import {FormAddServiceComponent} from "../components/service/form-add-service/form-add-service.component";
import {FormAddContractComponent} from "../components/contract/form-add-contract/form-add-contract.component";
import {FormAddContractDetailComponent} from "../components/contract/form-add-contract-detail/form-add-contract-detail.component";
import {EditCustomerComponent} from "../components/customer/edit-customer/edit-customer.component";
import {ListCustomerUsingServiceComponent} from "../components/list-customer-using-service/list-customer-using-service.component";
import {EditEmployeeComponent} from "../components/employee/edit-employee/edit-employee.component";

const routes: Routes = [
  {
    path: "customer",
    component: ListCustomerComponent
  },
  {
    path: "customer/add",
    component: AddCustomerComponent
  },
  {
    path: "customer/edit/:id",
    component: EditCustomerComponent
  },
  {
    path: "employee",
    component: ListEmployeeComponent
  },
  {
    path: "employee/add",
    component: FormAddEmployeeComponent
  },
  {
    path: "employee/edit/:id",
    component: EditEmployeeComponent
  },
  {
    path: "service",
    component: ListServiceComponent
  },
  {
    path: "service/add",
    component: FormAddServiceComponent
  },
  {
    path: "contract/add",
    component: FormAddContractComponent
  },
  {
    path: "contractDetail",
    component: FormAddContractDetailComponent
  },
  {
    path: "",
    component: ListCustomerUsingServiceComponent
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule {
}
