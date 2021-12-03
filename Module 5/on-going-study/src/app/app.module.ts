import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {StudentListComponent} from './student-list/student-list.component';
import {StudentAddFormComponent} from './student-add-form/student-add-form.component';
import {DrivenFormAddComponent} from './driven-form-add/driven-form-add.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { StudentDetailComponent } from './student-detail/student-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentAddFormComponent,
    DrivenFormAddComponent,
    StudentDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
