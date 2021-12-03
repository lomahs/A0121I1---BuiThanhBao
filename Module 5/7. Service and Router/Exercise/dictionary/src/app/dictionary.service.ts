import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {

  dictionary: Array<{ word: string, mean: string }> = [
    {
      word: 'Dog',
      mean: 'Con chó'
    },
    {
      word: 'Cat',
      mean: 'Con mèo'
    },
    {
      word: 'Elephant',
      mean: 'Con voi'
    },
    {
      word: 'Pig',
      mean: 'Con heo'
    },
    {
      word: 'Mouse',
      mean: 'Con chuột'
    }
  ]

  constructor() {
  }

  getDictionary() {
    return this.dictionary;
  }

  getWordMean(word: string | null): { word: string; mean: string } | null {
    let mean = this.dictionary.find(w => w.word === word);

    if (mean) {
      return mean;
    } else {
      return null;
    }
  }
}
