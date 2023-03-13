import {Injectable} from '@angular/core';
import {Customer} from '../customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  customers: Customer[] = [
    {
      name: 'Nguyễn Văn A',
      birthOfDay: '03-10-1999',
      gender: true,
      idCard: '123456789',
      phoneNumber: '0395319914',
      email: 'a@gmail.com',
      address: 'Đà Nẵng',
      customerType: 'Diamond'
    },
    {
      name: 'Nguyễn Văn D',
      birthOfDay: '07-09-2001',
      gender: false,
      idCard: '123789789',
      phoneNumber: '0395319456',
      email: 'd@gmail.com',
      address: 'Hà Nội',
      customerType: 'Gold'
    }, {
      name: 'Nguyễn Văn B',
      birthOfDay: '03-01-1995',
      gender: false,
      idCard: '123456456',
      phoneNumber: '0395319911',
      email: 'b@gmail.com',
      address: 'Huế',
      customerType: 'Platinium'
    }, {
      name: 'Nguyễn Văn C',
      birthOfDay: '09-02-1997',
      gender: true,
      idCard: '123456123',
      phoneNumber: '0395319933',
      email: 'c@gmail.com',
      address: 'HCM',
      customerType: 'Member'
    }
  ];

  constructor() {
  }

  findAll(): Customer[] {
    return this.customers;
  }
}
