import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient) {}
  api = 'http://localhost:8080/';
  feedback = [ ];

  getCommonFeedback() {
    const email = 'ramsingh@gmail.com';
  // JSON.parse(localStorage.getItem('user')).email
    this.http.get<any>(`${this.api}getCommonFeedback?email=${email}`).subscribe(res => {
      console.log(res);
      this.feedback = res.commonFeedbackList;
      console.log(this.feedback);
    });
  }

  addCommonFeedback(data) {
    const value = {name: 'Yash Patil',
  email: 'yashpatil@gmail.com' ,
  brandName: data.brandName,
    rating: data.rating,
    feedback: data.feedback
  };
    return this.http.post<any>(`${this.api}insertCommonFeedback`, value);
  // JSON.parse(localStorage.getItem('user')).name
  // JSON.parse(localStorage.getItem('user')).email
  }

  addProductFeedback(data) {
    const value = {
      productId: data.productId,
      name: 'Yash Patil',
      email: 'yashpatil@gmail.com',
      rating: data.rating,
      feedback: data.feedback
    };
    return this.http.post<any>(`${this.api}insertProductFeedback`, value);
  }

}
