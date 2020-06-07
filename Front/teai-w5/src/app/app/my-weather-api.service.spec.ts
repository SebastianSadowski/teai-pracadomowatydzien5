import { TestBed } from '@angular/core/testing';

import { MyWeatherAPIService } from './my-weather-api.service';

describe('MyWeatherAPIService', () => {
  let service: MyWeatherAPIService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyWeatherAPIService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
