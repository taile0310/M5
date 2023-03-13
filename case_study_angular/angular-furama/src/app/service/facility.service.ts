import {Injectable} from '@angular/core';
import {Facility} from '../facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  facilitys: Facility[] = [
    {
      name: 'Room Twin 1',
      area: 50,
      cost: 5000000,
      maxPeople: 5,
      standardRoom: 'Superior',
      description: 'kara',
      poolArea: 0,
      numberOfFloors: 0,
      facilityFree: 'xe đạp',
      rentType: 'day',
      facilityType: 'Room',
      img: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Lagoon-Superior-twin-bed-M-1047x563.jpg'
    },
    {
      name: 'House Beach',
      area: 100,
      cost: 10000000,
      maxPeople: 10,
      standardRoom: 'Luxury',
      description: 'Tủ lạnh',
      poolArea: 12,
      numberOfFloors: 2,
      facilityFree: 'xe máy',
      rentType: 'month',
      facilityType: 'House',
      img: 'https://img.tripi.vn/cdn-cgi/image/width=640/https://i.travelapi.com/hotels/49000000/48870000/48869100/48869049/7eff3798.jpg'
    },
    {
      name: 'Villa Beach',
      area: 150,
      cost: 15000000,
      maxPeople: 15,
      standardRoom: 'Luxury',
      description: 'Đầy đủ tiện nghi',
      poolArea: 15,
      numberOfFloors: 2,
      facilityFree: 'xe đạp',
      rentType: 'year',
      facilityType: 'Villa',
      img: 'http://3.bp.blogspot.com/-aSv5idU0cs4/UG-d3KihpPI/AAAAAAAAADk/Evx9LD3C4eE/s1600/Furama-Villas-Danang-1.jpg'
    }
  ];

  constructor() {
  }

  findAll(): Facility[] {
    return this.facilitys;
  }
}
