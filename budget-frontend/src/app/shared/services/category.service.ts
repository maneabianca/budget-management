import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ITransaction} from '../types/transaction';

@Injectable()
export class CategoryService {

  baseUrl = 'http://localhost:8080/api/v1/category';
  private headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders({'Content-Type': 'application/json'});
  }

  getCategoryListByType(id: number, type: string): Observable<any> {
    return this.http.get<ITransaction>(this.baseUrl + '/' + id + '/list?type=' + type);
  }

}
