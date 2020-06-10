import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CommonFeedbackCustomerComponent } from './common-feedback-customer/common-feedback-customer.component';
import { CommonFeedbackMerchantComponent } from './common-feedback-merchant/common-feedback-merchant.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CommonFeedbackCustomerComponent,
    CommonFeedbackMerchantComponent,
    OrderhistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
