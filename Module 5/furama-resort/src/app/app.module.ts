import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {FooterComponent} from './components/footer/footer.component';
import {HeaderComponent} from './components/header/header.component';
import {AddCustomerComponent} from './components/customer/add-customer/add-customer.component';
import {FormAddEmployeeComponent} from './components/employee/form-add-employee/form-add-employee.component';
import {FormAddServiceComponent} from './components/service/form-add-service/form-add-service.component';
import {FormAddContractComponent} from './components/contract/form-add-contract/form-add-contract.component';
import {FormAddContractDetailComponent} from './components/contract/form-add-contract-detail/form-add-contract-detail.component';
import {ListCustomerComponent} from './components/customer/list-customer/list-customer.component';
import {ListEmployeeComponent} from './components/employee/list-employee/list-employee.component';
import {ListServiceComponent} from './components/service/list-service/list-service.component';
import {ListCustomerUsingServiceComponent} from './components/list-customer-using-service/list-customer-using-service.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {AppRoutingModule} from "./app-routing/app-routing.module";
import {EditCustomerComponent} from './components/customer/edit-customer/edit-customer.component';
import {DeleteCustomerComponent} from './components/customer/delete-customer/delete-customer.component';
import {MatDialogModule} from "@angular/material/dialog";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatButtonModule} from "@angular/material/button";
import {NgxPaginationModule} from "ngx-pagination";
import {DeleteEmployeeComponent} from './components/employee/delete-employee/delete-employee.component';
import {EditEmployeeComponent} from './components/employee/edit-employee/edit-employee.component';
import {DeleteServiceComponent} from './components/service/delete-service/delete-service.component';
import {EditServiceComponent} from './components/service/edit-service/edit-service.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    AddCustomerComponent,
    FormAddEmployeeComponent,
    FormAddServiceComponent,
    FormAddContractComponent,
    FormAddContractDetailComponent,
    ListCustomerComponent,
    ListEmployeeComponent,
    ListServiceComponent,
    ListCustomerUsingServiceComponent,
    EditCustomerComponent,
    DeleteCustomerComponent,
    DeleteEmployeeComponent,
    EditEmployeeComponent,
    DeleteServiceComponent,
    EditServiceComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    MatDialogModule,
    MatSnackBarModule,
    MatButtonModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
