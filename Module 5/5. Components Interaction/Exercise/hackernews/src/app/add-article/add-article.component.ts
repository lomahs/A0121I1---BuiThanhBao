import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

  @Output()
  addArticleEvent = new EventEmitter<{
    title: string,
    url: string
  }>();

  addArticle(title: string, url: string) {
    this.addArticleEvent.emit({
      title,
      url
    });
  }
}
