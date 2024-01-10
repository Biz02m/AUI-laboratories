import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeOfBeerListComponent } from './type-of-beer-list.component';

describe('TypeOfBeerListComponent', () => {
  let component: TypeOfBeerListComponent;
  let fixture: ComponentFixture<TypeOfBeerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TypeOfBeerListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TypeOfBeerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
