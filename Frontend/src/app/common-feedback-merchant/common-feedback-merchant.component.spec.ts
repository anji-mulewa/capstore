import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommonFeedbackMerchantComponent } from './common-feedback-merchant.component';

describe('CommonFeedbackMerchantComponent', () => {
  let component: CommonFeedbackMerchantComponent;
  let fixture: ComponentFixture<CommonFeedbackMerchantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommonFeedbackMerchantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommonFeedbackMerchantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
