import {ComponentFixture, TestBed} from '@angular/core/testing';

import {DrivenFormAddComponent} from './driven-form-add.component';

describe('DrivenFormAddComponent', () => {
  let component: DrivenFormAddComponent;
  let fixture: ComponentFixture<DrivenFormAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DrivenFormAddComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DrivenFormAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
