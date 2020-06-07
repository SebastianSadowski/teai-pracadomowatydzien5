import { Component, OnInit } from '@angular/core';
import * as L from 'leaflet';
import { MapExtensionService } from './map-extension.service';
import { HttpClient } from '@angular/common/http';
import { getSyntheticPropertyName } from '@angular/compiler/src/render3/util';
import { MyWeatherAPIService } from '../my-weather-api.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {
private map;
private cityname;
  constructor(private mapExtension: MapExtensionService, private http: HttpClient, private myWeather: MyWeatherAPIService) { }

  ngOnInit(): void {
    this.initMap();
  }

  private initMap(): void {
    this.map = L.map('map', {
                     center: [ 51.8282, 19.5795 ],
                     zoom: 6});

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                                 maxZoom: 19,
                                 attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'});


    tiles.addTo(this.map);
  }

  public closeMap(){
    this.mapExtension.changeVisibility(false);
  }
public acceptMarker(){
  this.myWeather.getWeatherForCity(this.cityname);


}
addMarker(){
  let lat;
  let lon;
  let marker;
  this.map.on('click', e => {
    lat = e.latlng.lat;
    lon = e.latlng.lng;

    console.log('You clicked the map at LAT: ' + lat + ' and LONG: ' + lon );
    if (marker !== undefined){
  this.map.removeLayer(marker);

}else{
  marker = L.marker([lat, lon]).addTo(this.map);
  this.getCitynameByLatLon(lat, lon);
  setTimeout( () => {marker.bindPopup('<br>'+ this.cityname).openPopup();}, 1000);
  }
}); }



private getCitynameByLatLon(lat?: string, lon?: string): void{

  this.http.get<string>('http://localhost:8080/cityname/?lat='+lat+'&lon='+lon)
  .subscribe(cd => {this.cityname = cd; console.log(cd);});
  }

}

