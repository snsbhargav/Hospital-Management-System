import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowPatientDetailsComponent } from './show-patient-details.component';

describe('ShowPatientDetailsComponent', () => {
  let component: ShowPatientDetailsComponent;
  let fixture: ComponentFixture<ShowPatientDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowPatientDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowPatientDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
