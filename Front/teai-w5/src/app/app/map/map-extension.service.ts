import { Injectable } from '@angular/core';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MapExtensionService {
visibility = new Subject<boolean>();
  constructor() { }


public getVisibility(): Observable<boolean>{
  console.log('ktos mnie sliucha');
  return this.visibility.asObservable();
}
public changeVisibility(value: boolean): void {
  console.log('zmienilem sie w: ' +  value);
  this.visibility.next(value);
}}
