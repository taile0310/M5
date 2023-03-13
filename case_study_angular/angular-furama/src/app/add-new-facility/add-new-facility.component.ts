import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-add-new-facility',
  templateUrl: './add-new-facility.component.html',
  styleUrls: ['./add-new-facility.component.css']
})
export class AddNewFacilityComponent implements OnInit {
  rfFacility: FormGroup;

  constructor() {
  }

  ngOnInit(): void {
    this.rfFacility = new FormGroup(
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

  addFacility() {
    console.log(this.rfFacility.value);
  }
}
