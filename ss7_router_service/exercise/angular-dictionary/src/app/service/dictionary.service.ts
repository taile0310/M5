import {Injectable} from '@angular/core';
import {Dictionary} from '../dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  words: Dictionary[] = [
    {
      english: 'name',
      vietnamese: 'tên'
    },
    {
      english: 'what',
      vietnamese: 'cái gì'
    },
    {
      english: 'who',
      vietnamese: 'ai'
    },
    {
      english: 'red',
      vietnamese: 'màu đỏ'
    }
  ];

  constructor() {
  }

  findAll(): Dictionary[] {
    return this.words;
  }

  findByName(english: string): Dictionary {
    return this.words.filter(it => it.english === english)[0];
  }
}
