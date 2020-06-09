import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommonFeedbackCustomerComponent } from './common-feedback-customer.component';

describe('CommonFeedbackCustomerComponent', () => {
  let component: CommonFeedbackCustomerComponent;
  let fixture: ComponentFixture<CommonFeedbackCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommonFeedbackCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommonFeedbackCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
