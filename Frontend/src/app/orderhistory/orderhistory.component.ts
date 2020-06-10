import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { orderdata } from '../orderdetails';
import { NgForm } from '@angular/forms';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-orderhistory',
  templateUrl: './orderhistory.component.html',
  styleUrls: ['./orderhistory.component.css']
})
export class OrderhistoryComponent implements OnInit {

  historydetails = [];
  orders = [];
  selectedProduct: orderdata = {
     email: null,
     address: null,
     pincode: null,
     totalbill: null,
     paymentMode: null,
     productQuality: null,
     productName: null,
     productId: null

  };
  constructor(private history: CustomerService, private feedbackService: FeedbackService) {
    this.orderdetails();
  }

  orderdetails() {
    this.history.orderdetails().subscribe(data => {
      console.log(data.orderList);
      this.historydetails = data.orderList;
    },
      err => {
        console.log(err);
      });

  }

  selectProduct(historydetails1) {
    this.selectedProduct = historydetails1;
    console.log( this.selectedProduct);
  }

  submitForm(productFeedback: NgForm) {
    this.feedbackService.addProductFeedback(productFeedback.value).subscribe(res => {
      console.log(res);
    });
    productFeedback.reset();
  }

  ngOnInit(): void {
  }

}
