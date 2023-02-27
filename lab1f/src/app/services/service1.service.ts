import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';   // import client
import { BehaviorSubject, Observable } from 'rxjs';
import { Entity } from '../interfaces/entity';

@Injectable({
  providedIn: 'root'       // accesible for whole angular project
})
export class Service1Service {

  list = new BehaviorSubject<Entity[]>([]);                  // BehaviorSubject - to be able to update Entities

  url:string="http://localhost:8080/lection1-web/servlet"    // full path to servlet

  // paste client in constructor
  constructor(private http:HttpClient) { }    
  
  getEntities():Observable<Entity[]>{                        // returns entities from url given above
    return this.http.get<Entity[]>(this.url);                // gives a list of entities
  }

  postEntity(entity:Entity):Observable<Entity[]>{
    return this.http.post<Entity[]>(this.url, entity);       // post function
  }

  putEntity(entity:Entity):Observable<Entity[]>{
    return this.http.put<Entity[]>(this.url+"/"+entity.name, entity);   // put function
  }

  deleteEntity(entity:Entity):Observable<Entity[]>{
    return this.http.delete<Entity[]>(this.url+"/"+entity.name);        // delete function
  }
}
