import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';   // import client
import { Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'       // accesible for whole angular project
})
export class Service1Service {
url:string="http://localhost:8080/lection1-web/servlet"    // full path to servlet

  // paste client in constructor
  constructor(private http:HttpClient) { }    
  
  getEntities():Observable<Entity[]>{                     // returns entities from url given above
    return this.http.get<Entity[]>(this.url);
  }
}
