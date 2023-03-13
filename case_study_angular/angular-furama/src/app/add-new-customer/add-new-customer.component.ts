import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-new-customer',
  templateUrl: './add-new-customer.component.html',
  styleUrls: ['./add-new-customer.component.css']
})
export class AddNewCustomerComponent implements OnInit {
  rfCustomer: FormGroup;

  constructor() {
  }

  ngOnInit(): void {
    this.rfCustomer = new FormGroup(
      {
        customerCode: new FormControl('', [Validators.pattern('^[KH]$')]),
        name: new FormControl('', [Validators.pattern('^[A-Z][a-z]*([ ][A-Z][a-z]*)*$'), Validators.required]),
        idCard: new FormControl('', [Validators.pattern('^(?:\\d{9}|\\d{12})$'), Validators.required]),
        phoneNumber: new FormControl('', [Validators.pattern('(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b'), Validators.required]),
        email: new FormControl('', [Validators.required, Validators.pattern('^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$')])
      }
    )
    ;
  }

  addCustomer() {
    console.log(this.rfCustomer.value);
  }
}
