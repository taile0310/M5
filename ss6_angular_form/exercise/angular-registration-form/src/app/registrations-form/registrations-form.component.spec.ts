import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationsFormComponent } from './registrations-form.component';

describe('RegistrationsFormComponent', () => {
  let component: RegistrationsFormComponent;
  let fixture: ComponentFixture<RegistrationsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
