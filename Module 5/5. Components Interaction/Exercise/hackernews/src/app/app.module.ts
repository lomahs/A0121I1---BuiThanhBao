import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HackernewsComponent } from './hackernews/hackernews.component';
import { LikesComponent } from './likes/likes.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DetailArticleComponent } from './detail-article/detail-article.component';
import { AddArticleComponent } from './add-article/add-article.component';

@NgModule({
  declarations: [
    AppComponent,
    HackernewsComponent,
    LikesComponent,
    FooterComponent,
    NavbarComponent,
    DetailArticleComponent,
    AddArticleComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
