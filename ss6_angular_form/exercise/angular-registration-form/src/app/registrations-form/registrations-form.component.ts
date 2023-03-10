import {Component, EventEmitter, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {RegistrationForm} from '../registration-form';

@Component({
  selector: 'app-registrations-form',
  templateUrl: './registrations-form.component.html',
  styleUrls: ['./registrations-form.component.css']
})
export class RegistrationsFormComponent implements OnInit {
  rfRegistrationsForm: FormGroup;


  constructor() {
  }

  ngOnInit(): void {
    this.rfRegistrationsForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [this.checkAge, Validators.required]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\\b$')])
    });
  }

  // custom validate
  checkAge(ages: AbstractControl) {
    const age = ages.value;
    if (age < 18) {
      return {invalidAge: true};
    }
    return null;
  }


  add() {
    console.log(this.rfRegistrationsForm.value);
  }
}
