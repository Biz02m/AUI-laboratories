import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeOfBeerViewComponent } from './type-of-beer-view.component';

describe('TypeOfBeerViewComponent', () => {
  let component: TypeOfBeerViewComponent;
  let fixture: ComponentFixture<TypeOfBeerViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TypeOfBeerViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TypeOfBeerViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
