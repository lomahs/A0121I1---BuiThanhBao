import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterModule, Routes} from "@angular/router";
import {StudentListComponent} from "./student-list/student-list.component";
import {StudentAddFormComponent} from "./student-add-form/student-add-form.component";
import {StudentDetailComponent} from "./student-detail/student-detail.component";

const routes: Routes = [
  {
    path: '',
    component: StudentListComponent
  },
  {
    path: 'create',
    component: StudentAddFormComponent
  },
  {
    path: 'detail/:id',
    component: StudentDetailComponent
  }
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
