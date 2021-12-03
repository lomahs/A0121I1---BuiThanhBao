import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAddContractComponent } from './form-add-contract.component';

describe('FormAddContractComponent', () => {
  let component: FormAddContractComponent;
  let fixture: ComponentFixture<FormAddContractComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormAddContractComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAddContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
