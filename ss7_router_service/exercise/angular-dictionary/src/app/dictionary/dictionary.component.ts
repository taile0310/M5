import {Component, OnInit} from '@angular/core';
import {DictionaryService} from '../service/dictionary.service';
import {Dictionary} from '../dictionary';

@Component({
  selector: 'app-dictionary',
  templateUrl: './dictionary.component.html',
  styleUrls: ['./dictionary.component.css']
})
export class DictionaryComponent implements OnInit {
  dictionarys: Dictionary[];

  constructor(private dictionaryService: DictionaryService) {
  }

  ngOnInit(): void {
    this.dictionarys = this.dictionaryService.findAll();
  }

}
