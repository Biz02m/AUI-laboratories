import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeerPutComponent } from './beer-put.component';

describe('BeerPutComponent', () => {
  let component: BeerPutComponent;
  let fixture: ComponentFixture<BeerPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BeerPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BeerPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
