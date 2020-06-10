import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonFeedbackCustomerComponent } from './common-feedback-customer/common-feedback-customer.component';
import { CommonFeedbackMerchantComponent } from './common-feedback-merchant/common-feedback-merchant.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';


const routes: Routes = [
  { path: 'common-feedback-customer', component: CommonFeedbackCustomerComponent },
  { path: 'common-feedback-merchant', component: CommonFeedbackMerchantComponent },
  { path: 'orderhistory', component: OrderhistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
