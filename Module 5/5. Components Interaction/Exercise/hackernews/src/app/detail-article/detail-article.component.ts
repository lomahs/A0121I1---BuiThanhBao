import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.css']
})
export class DetailArticleComponent implements OnInit {

  @Input()
  article={
    title: "",
    url: "",
  }

  constructor() { }

  ngOnInit(): void {
  }


}
