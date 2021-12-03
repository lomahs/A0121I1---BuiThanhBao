import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {FooterComponent} from './components/footer/footer.component';
import {HeaderComponent} from './components/header/header.component';
import {FormAddCustomerComponent} from './components/form-add-customer/form-add-customer.component';
import {FormAddEmployeeComponent} from './components/form-add-employee/form-add-employee.component';
import {FormAddServiceComponent} from './components/form-add-service/form-add-service.component';
import {FormAddContractComponent} from './components/form-add-contract/form-add-contract.component';
import {FormAddContractDetailComponent} from './components/form-add-contract-detail/form-add-contract-detail.component';
import {ListCustomerComponent} from './components/list-customer/list-customer.component';
import {ListEmployeeComponent} from './components/list-employee/list-employee.component';
import {ListServiceComponent} from './components/list-service/list-service.component';
import {ListCustomerUsingServiceComponent} from './components/list-customer-using-service/list-customer-using-service.component';
import {ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    FormAddCustomerComponent,
    FormAddEmployeeComponent,
    FormAddServiceComponent,
    FormAddContractComponent,
    FormAddContractDetailComponent,
    ListCustomerComponent,
    ListEmployeeComponent,
    ListServiceComponent,
    ListCustomerUsingServiceComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
