import { Component, OnInit } from '@angular/core';
import { MyWeatherAPIService, Weather } from '../my-weather-api.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  public weather: Weather;

  constructor(private weatherProvider: MyWeatherAPIService) { }

  ngOnInit(): void {
    this.weatherProvider.getWeather().subscribe(w =>
     {this.weather = w;
      console.log(w);
    });
  }

}
