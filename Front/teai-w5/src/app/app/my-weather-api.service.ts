import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

@Injectable()
export class MyWeatherAPIService {

weather = new Subject<Weather>();
  constructor(private http: HttpClient ){
    this.http = http;
  }

getWeatherForCity(city: string): void{
  const path = 'http://localhost:8080/weather/' + city;
  this.http.get<Weather>(path).subscribe(w => this.weather.next(w));

}

getWeather(): Observable<Weather>{
  return this.weather.asObservable();
}


}
export interface Weather {
  city: string;
  temperature: number;
  weatherIcons: string[];
  windSpeed: number;
  windDir: string;
  pressure: number;
  humidity: number;
  cloudcover: number;
}

