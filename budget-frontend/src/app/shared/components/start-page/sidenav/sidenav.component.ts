import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {AddTransactionComponent} from '../transaction/add-transaction/add-transaction.component';


@Component({

  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})

export class SidenavComponent implements OnInit {

  constructor(public dialog: MatDialog) {
  }

  openDialog(): void {
    this.dialog.open(AddTransactionComponent, {
      width: '500px',
      height: '550px',
    });
  }

  ngOnInit(): void {
  }
}

