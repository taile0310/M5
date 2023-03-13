import {Component, OnInit} from '@angular/core';
import {Dictionary} from '../dictionary';
import {DictionaryService} from '../service/dictionary.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  dictionarys: Dictionary;

  constructor(private dictionaryService: DictionaryService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      const english = paramMap.get('english');
      this.dictionarys = this.dictionaryService.findByName(english);
    });
  }

}
