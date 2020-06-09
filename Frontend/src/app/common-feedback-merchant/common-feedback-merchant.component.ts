import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-common-feedback-merchant',
  templateUrl: './common-feedback-merchant.component.html',
  styleUrls: ['./common-feedback-merchant.component.css']
})
export class CommonFeedbackMerchantComponent implements OnInit {

  constructor(private feedbackService: FeedbackService) {
    this.feedbackService.getCommonFeedback();
  }

  ngOnInit() {
  }

}
