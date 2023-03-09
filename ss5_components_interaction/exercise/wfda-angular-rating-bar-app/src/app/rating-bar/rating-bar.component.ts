import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IRatingUnit} from '../i-rating-unit';

@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit {
  @Input()
  max = 10;
  @Input()
  ratingValue = 5;
  @Input()
  showRatingValue = true;

  @Output()
  rateChange = new EventEmitter<number>();

  ratingUnits: Array<IRatingUnit> = [];

  constructor() {
  }


  calculate(max, ratingValue) {
    for (let i = 0; i < max; i++) {
      this.ratingUnits[i] = {
        value: i + 1,
        active: i < ratingValue
      };
    }
  }

  ngOnInit() {
    this.calculate(this.max, this.ratingValue);
  }

  select(index) {
    this.ratingValue = index + 1;
    this.reset();
  }


  enter(index) {
    for (let i = 0; i < this.max; i++) {
      this.ratingUnits[i].active = i <= index;
    }
  }

  reset() {
    for (let i = 0; i < this.max; i++) {
      this.ratingUnits[i].active = i < this.ratingValue;
    }
  }
}
