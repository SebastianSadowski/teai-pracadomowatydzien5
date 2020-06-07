import { TestBed } from '@angular/core/testing';

import { MapExtensionService } from './map-extension.service';

describe('MapExtensionService', () => {
  let service: MapExtensionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MapExtensionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
