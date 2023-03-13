import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-add-new-contract',
  templateUrl: './add-new-contract.component.html',
  styleUrls: ['./add-new-contract.component.css']
})
export class AddNewContractComponent implements OnInit {
  rfContract: FormGroup;

  constructor() {
  }

  ngOnInit(): void {
    this.rfContract = new FormGroup(
      {
        deposit: new FormControl('', [this.checkDeposit])
      }
    );
  }

// custom deposit
  checkDeposit(deposits: AbstractControl) {
    const deposit = deposits.value;
    // nếu deposit nhỏ hơn 0 thì hàm trả về true, tức là đúng với điều kiện thì trả về lỗi
    if (deposit < 0) {
      return {invalidDeposit: true};
    }
    // nếu deposit lớn hơn 0 thì hàm trả về null, có nghĩa là hợp lệ thì không báo lỗi
    return null;
  }

  addContract() {
    console.log(this.rfContract.value);
  }
}
