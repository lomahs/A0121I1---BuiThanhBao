import {ComponentFixture, TestBed} from '@angular/core/testing';

import {FormAddEmployeeComponent} from './form-add-employee.component';

describe('FormAddEmployeeComponent', () => {
  let component: FormAddEmployeeComponent;
  let fixture: ComponentFixture<FormAddEmployeeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FormAddEmployeeComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAddEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
