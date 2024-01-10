import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeOfBeerEditComponent } from './type-of-beer-edit.component';

describe('TypeOfBeerEditComponent', () => {
  let component: TypeOfBeerEditComponent;
  let fixture: ComponentFixture<TypeOfBeerEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TypeOfBeerEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TypeOfBeerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
