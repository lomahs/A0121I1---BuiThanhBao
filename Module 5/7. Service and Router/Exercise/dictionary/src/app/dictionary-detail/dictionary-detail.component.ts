import {Component, OnInit} from '@angular/core';
import {DictionaryService} from "../dictionary.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  // @ts-ignore
  word: { word: string; mean: string } | null

  constructor(private dictionaryService: DictionaryService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(
      (paramMap) => {
        const key = paramMap.get('key');
        this.word = this.dictionaryService.getWordMean(key);
      }
    )
  }

}
