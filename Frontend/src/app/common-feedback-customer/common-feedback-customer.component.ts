import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-common-feedback-customer',
  templateUrl: './common-feedback-customer.component.html',
  styleUrls: ['./common-feedback-customer.component.css']
})
export class CommonFeedbackCustomerComponent implements OnInit {

  constructor(private feedbackService: FeedbackService) { }

  submitForm(insertCommonFeedbackForm: NgForm){
    this.feedbackService.addCommonFeedback(insertCommonFeedbackForm.value).subscribe(res => {
      console.log('response', res);
    },
    err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
