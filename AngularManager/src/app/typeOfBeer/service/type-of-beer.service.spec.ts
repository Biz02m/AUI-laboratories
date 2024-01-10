import { TestBed } from '@angular/core/testing';

import { TypeOfBeerService } from './type-of-beer.service';

describe('TypeOfBeerService', () => {
  let service: TypeOfBeerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeOfBeerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
