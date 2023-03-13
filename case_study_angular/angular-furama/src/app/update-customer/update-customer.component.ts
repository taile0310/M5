import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  rfUpdateCustomer: FormGroup;

  constructor() { }

 ngOnInit(): void {
   this.rfUpdateCustomer = new FormGroup(
     {
       name: new FormControl('', [Validators.pattern('^[A-Z][a-z]*([ ][A-Z][a-z]*)*$'), Validators.required]),
       idCard: new FormControl('', [Validators.pattern('^(?:\\d{9}|\\d{12})$'), Validators.required]),
       phoneNumber: new FormControl('', [Validators.pattern('(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b'), Validators.required]),
       email: new FormControl('', [Validators.required, Validators.pattern('^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$')])
     }
   )
   ;
 }

  updateCustomer() {
    console.log(this.rfUpdateCustomer.value);
  }
}
