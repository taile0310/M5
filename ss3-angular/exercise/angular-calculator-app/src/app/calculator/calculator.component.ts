import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  result: number;

  constructor() { }

  ngOnInit(): void {
  }

  summation(num1: string, num2: string){
    this.result = parseInt(num1) + parseInt(num2);
  }

  subtraction(num1: string, num2: string) {
    this.result = parseInt(num1) - parseInt(num2);
  }

  multiplication(num1: string, num2: string) {
    this.result = parseInt(num1) * parseInt(num2);
  }

  division(num1: string, num2: string) {
    this.result = parseInt(num1) / parseInt(num2);
  }
}
