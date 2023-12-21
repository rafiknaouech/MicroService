import { TestBed } from '@angular/core/testing';

import { SharddService } from './shardd.service';

describe('SharddService', () => {
  let service: SharddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SharddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
