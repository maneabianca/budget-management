import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ITransaction} from '../types/transaction';

@Injectable()
export class TransactionService {

  baseUrl = 'http://localhost:8080/api/v1/transaction';
  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders({'Content-Type': 'application/json'});
  }

  getTransactionList(): Observable<any> {
    return this.http.get<ITransaction[]>(this.baseUrl + '/list');
  }
  createTransaction(newTransaction: ITransaction): Observable<any> {
    return this.http.post<ITransaction>(this.baseUrl + '/create', newTransaction);
  }
}
