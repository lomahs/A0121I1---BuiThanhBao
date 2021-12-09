import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ListShowtimeComponent} from "./list-showtime/list-showtime.component";
import {AddShowtimeComponent} from "./add-showtime/add-showtime.component";

const routes: Routes = [
  {
    path: "",
    component: ListShowtimeComponent
  },
  {
    path: "add",
    component: AddShowtimeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
