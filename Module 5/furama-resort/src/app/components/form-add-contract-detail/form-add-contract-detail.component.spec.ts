import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAddContractDetailComponent } from './form-add-contract-detail.component';

describe('FormAddContractDetailComponent', () => {
  let component: FormAddContractDetailComponent;
  let fixture: ComponentFixture<FormAddContractDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAddContractDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAddContractDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
