import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {ImgSliderModule} from "./img-slider/img-slider.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ImgSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
