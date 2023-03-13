import {Injectable} from '@angular/core';
import {Contract} from '../contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  contracts: Contract[] = [
    {
      startDay: '12-03-2023',
      endDay: '13-03-2023',
      deposit: 500000,
      employee: 'Nguyễn thị linh',
      customer: 'Nguyên văn a',
      facility: 'Villa',
      total: 15000000
    },
    {
      startDay: '12-03-2023',
      endDay: '15-03-2023',
      deposit: 200000,
      employee: 'Nguyễn thị linh',
      customer: 'Nguyên văn b',
      facility: 'Villa',
      total: 25000000
    },
    {
      startDay: '12-03-2023',
      endDay: '19-03-2023',
      deposit: 1000000,
      employee: 'Nguyễn thị linh',
      customer: 'Nguyên văn c',
      facility: 'House',
      total: 10000000
    },
    {
      startDay: '12-03-2023',
      endDay: '14-03-2023',
      deposit: 600000,
      employee: 'Nguyễn thị linh',
      customer: 'Nguyên văn d',
      facility: 'Room',
      total: 5000000
    }
  ];


  constructor() {
  }

  findAll(): Contract[] {
    return this.contracts;
  }
}
