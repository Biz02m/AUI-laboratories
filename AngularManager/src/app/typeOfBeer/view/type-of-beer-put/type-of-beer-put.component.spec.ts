import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeOfBeerPutComponent } from './type-of-beer-put.component';

describe('TypeOfBeerPutComponent', () => {
  let component: TypeOfBeerPutComponent;
  let fixture: ComponentFixture<TypeOfBeerPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TypeOfBeerPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TypeOfBeerPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
