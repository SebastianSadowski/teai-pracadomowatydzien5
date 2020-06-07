import { Component, OnInit } from '@angular/core';
import { Weather, MyWeatherAPIService } from '../my-weather-api.service';
import { MapExtensionService } from '../map/map-extension.service';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css'],
})
export class ToolbarComponent implements OnInit {
cityName;
displayedCityName;
  constructor(private weatherProvider: MyWeatherAPIService, private mapExtension: MapExtensionService) { }

  ngOnInit(): void {
  this.weatherProvider.getWeather().subscribe(w => this.displayedCityName = w.city);
  }

  getWeatherForCity(): void {
this.weatherProvider.getWeatherForCity(this.cityName);
}

openMap(){
  this.mapExtension.changeVisibility(true);
}
}
