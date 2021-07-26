import {Component, Input, OnInit} from '@angular/core';
import {ITransaction} from '../../../../types/transaction';

@Component({
  selector: 'app-transaction-card',
  templateUrl: './transaction-card.component.html',
  styleUrls: ['./transaction-card.component.css']
})
export class TransactionCardComponent implements OnInit {
  @Input() transaction: ITransaction;
  constructor() { }

  ngOnInit(): void {
  }

}
