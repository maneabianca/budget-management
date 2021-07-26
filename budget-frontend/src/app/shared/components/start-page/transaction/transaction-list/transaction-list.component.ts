import { Component, OnInit } from '@angular/core';
import {ITransaction} from '../../../../types/transaction';
import {TransactionService} from '../../../../services/transaction.service';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  transactions: ITransaction[];
  constructor(private transactionService: TransactionService) {
  }

  ngOnInit(): void {
    this.transactionService.getTransactionList().subscribe(
      (data: ITransaction[]) => {
        this.transactions = data;
      },
      (err: any) => console.log(err)
    );
  }
}
