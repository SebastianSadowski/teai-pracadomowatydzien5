import { Component, OnInit } from '@angular/core';
import { MapExtensionService } from './app/map/map-extension.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'teai-w5';
  visibility;
constructor(private mapExtension: MapExtensionService){}
  ngOnInit(): void {
   this.mapExtension.getVisibility().subscribe(v =>{ this.visibility = v;
                                                     console.log('dupa'); });
  }
}
