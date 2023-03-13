import {Component, OnInit} from '@angular/core';
import {Facility} from '../facility';
import {FacilityService} from '../service/facility.service';

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {
  facilitys: Facility[];

  constructor(private facilityService: FacilityService) {
  }

  ngOnInit(): void {
    this.facilitys = this.facilityService.findAll();
  }

}
