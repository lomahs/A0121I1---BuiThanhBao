import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCustomerUsingServiceComponent } from './list-customer-using-service.component';

describe('ListCustomerUsingServiceComponent', () => {
  let component: ListCustomerUsingServiceComponent;
  let fixture: ComponentFixture<ListCustomerUsingServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCustomerUsingServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCustomerUsingServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
