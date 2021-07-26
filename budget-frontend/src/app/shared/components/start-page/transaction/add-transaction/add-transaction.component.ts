import {Component, Inject, Input, OnInit} from '@angular/core';
import {ITransaction} from '../../../../types/transaction';
import {ICategory} from '../../../../types/category';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {IAccount} from '../../../../types/account';
import {ICurrency} from '../../../../types/currency';
import {IUser} from '../../../../types/user';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {CategoryService} from '../../../../services/category.service';
import {TransactionService} from '../../../../services/transaction.service';
import * as _moment from 'moment';
import {Moment} from 'moment';

const moment = _moment;

@Component({
  selector: 'app-add-transaction',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {
  type = '1';
  selected = '';
  @Input() transaction?: ITransaction;


  incomeCategories: ICategory[];
  expenseCategories: ICategory[];

  formTransaction: FormGroup;

  accountExample: IAccount;
  currencyExample: ICurrency;
  userExample: IUser;

  constructor(public dialogRef: MatDialogRef<AddTransactionComponent>,
              @Inject(MAT_DIALOG_DATA) public data: ITransaction,
              private formBuilder: FormBuilder,
              private categoryService: CategoryService,
              private transactionService: TransactionService) {

    this.userExample = {
      id: 2,
      email: 'manea.bianca092@gmail.com',
      password: '1234'
    };
    this.currencyExample = {
      id: 4,
      name: 'Canadian Dollar',
      code: 'CAD',
      value: 1.48
    };

    this.accountExample = {
      id: 1,
      name: 'My account 1',
      currentBalance: 0.0,
      currencyDto: this.currencyExample,
      userDto: this.userExample
    }
    ;
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.reactiveForm();
    this.transaction = {
      id: 0,
      transactionDate: '',
      description: '',
      value: 0,
      categoryDto: null,
      accountDto: null
    };
    this.categoryService.getCategoryListByType(2, 'INCOME').subscribe(
      (data: ICategory[]) => {
        this.incomeCategories = data;
      },
      (err: any) => console.log(err)
    );
    this.categoryService.getCategoryListByType(2, 'EXPENSES').subscribe(
      (data: ICategory[]) => {
        this.expenseCategories = data;
      },
      (err: any) => console.log(err)
    );
  }

  convertTransaction(trans) {


    const momentDate: Moment = trans.date; // Replace event.value with your date value
    const formattedDate = moment(momentDate).format('YYYY-MM-DD');
    console.log(formattedDate);
    console.log('trans before', this.transaction);
    this.transaction.transactionDate = formattedDate;
    this.transaction.value = trans.amount;
    this.transaction.categoryDto = trans.category;
    this.transaction.description = trans.note;
    this.transaction.accountDto = this.accountExample;
    return this.transaction;
  }

  submit() {
    this.transactionService.createTransaction( this.convertTransaction(this.formTransaction.value)).subscribe(
      (data: any) => {
        console.log('here');
        this.closeDialog();
        window.location.reload();
      },
      (err: any) => console.log(err)
    );
  }

  private reactiveForm() {
    this.formTransaction = this.formBuilder.group({
      type: ['1'],
      amount: ['', [Validators.required]],
      date: ['', [Validators.required]],
      category: [''],
      note: ['']
    });
  }

  public errorHandling = (control: string, error: string) => {
    return this.formTransaction.controls[control].hasError(error);
  }

}
