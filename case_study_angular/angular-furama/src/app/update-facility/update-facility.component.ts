import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-update-facility',
  templateUrl: './update-facility.component.html',
  styleUrls: ['./update-facility.component.css']
})
export class UpdateFacilityComponent implements OnInit {
  rfUpdateFacility: FormGroup;

  constructor() { }

  ngOnInit(): void {
    this.rfUpdateFacility = new FormGroup(
      {
        name: new FormControl('', [Validators.required, Validators.pattern('^[A-Z][a-z]*([ ][A-Z-Z0-9][a-z-z0-9]*)*$')]),
        area: new FormControl('', [Validators.required]),
        cost: new FormControl('', [Validators.required]),
        maxPeople: new FormControl('', [Validators.required]),
        standardRoom: new FormControl('', [Validators.required]),
        description: new FormControl('', [Validators.required]),
        poolArea: new FormControl('', [Validators.required, this.checkFloorAndPool]),
        numberOfFloors: new FormControl('', [Validators.required, this.checkFloorAndPool]),
        facilityFree: new FormControl('', [Validators.required]),
        rentType: new FormControl('', [Validators.required]),
        facilityType: new FormControl('', [Validators.required]),
        img: new FormControl('', [Validators.required]),
      }
    );
  }
  // custom arePool & numOfFloor
  checkFloorAndPool(controls: AbstractControl) {
    const poolAndFloor = controls.value;
    if (poolAndFloor < 0) {
      return {invalidPoolAndFloor: true};
    }
    return null;
  }

  updateFacility() {
    console.log(this.rfUpdateFacility.value);
  }
}
