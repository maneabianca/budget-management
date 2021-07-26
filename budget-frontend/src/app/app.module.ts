import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {SidenavComponent} from './shared/components/start-page/sidenav/sidenav.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatExpansionModule} from '@angular/material/expansion';
import {HttpClientModule} from '@angular/common/http';
import {TransactionService} from './shared/services/transaction.service';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MAT_DATE_FORMATS, MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatRadioModule} from '@angular/material/radio';
import {CategoryService} from './shared/services/category.service';
import {MomentDateModule} from '@angular/material-moment-adapter';
import {MY_DATE_FORMATS} from './shared/types/my-date-formats';
import { TransactionCardComponent } from './shared/components/start-page/transaction/transaction-card/transaction-card.component';
import { TransactionListComponent } from './shared/components/start-page/transaction/transaction-list/transaction-list.component';
import { AddTransactionComponent } from './shared/components/start-page/transaction/add-transaction/add-transaction.component';

@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
    TransactionCardComponent,
    TransactionListComponent,
    AddTransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatSidenavModule,
    MatExpansionModule,
    HttpClientModule,
    MatButtonModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatDialogModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MomentDateModule,
    MatRadioModule
  ],
  providers: [
    TransactionService,
    MatDialog,
    CategoryService,
    { provide: MAT_DATE_FORMATS, useValue: MY_DATE_FORMATS }
  ],
  entryComponents: [
    AddTransactionComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
