import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogUpdateOrderComponent } from './dialog-update-order.component';

describe('DialogUpdateOrderComponent', () => {
  let component: DialogUpdateOrderComponent;
  let fixture: ComponentFixture<DialogUpdateOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogUpdateOrderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogUpdateOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
