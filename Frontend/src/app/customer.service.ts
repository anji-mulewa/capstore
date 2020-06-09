import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }

  // email = JSON.parse(localStorage.getItem('panel'));
  api = `http://localhost:8080/`;
  email = 'ashwinyardi@gmail.com';
  email1='yashpatil@gmail.com';
  // productId

  viewprofile(profile) {
    return this.http.get<any>(`${this.api}viewprofile?email=${this.email}`);
  }
  updateProfile(update): Observable<any> {
    return this.http.post<any>(`${this.api}updateProfile`, update);
  }

  orderdetails(): Observable<any> {
    return this.http.get<any>(`${this.api}orderdetails?email=${this.email1}`);
  }

}