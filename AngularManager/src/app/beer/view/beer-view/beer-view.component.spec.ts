import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeerViewComponent } from './beer-view.component';

describe('BeerViewComponent', () => {
  let component: BeerViewComponent;
  let fixture: ComponentFixture<BeerViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BeerViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BeerViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
