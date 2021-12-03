import {Component, OnInit} from '@angular/core';
import {DictionaryService} from "../dictionary.service";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {

  dictionary: Array<{ word: string; mean: string }> = [];

  constructor(private dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.dictionary = this.dictionaryService.getDictionary();
  }

}
