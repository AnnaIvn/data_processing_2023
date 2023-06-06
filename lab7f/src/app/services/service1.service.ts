import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { Bags } from '../interfaces/bags';


@Injectable({
  providedIn: 'root'
})
export class Service1Service {
  list = new BehaviorSubject<Bags[]>([])

  url:string = "http://localhost:8080/bags";

  constructor(private http:HttpClient) { }

  postBags(entity:Bags):Observable<Bags[]>{
    return this.http.post<Bags[]>(this.url + "/create", entity);
  }

  getBags():Observable<Bags[]>{
    return this.http.get<Bags[]>(this.url + "/retrieve");
  }

  putBags(entity:Bags):Observable<Bags[]>{
    return this.http.put<Bags[]>(this.url + "/update" + `/${entity.id}`, entity);
  }

  deleteBags(entity:Bags):Observable<Bags[]>{
    return this.http.delete<Bags[]>(this.url + "/delete" + `/${entity.id}`)
  }

  setList(list:Bags[]){
    this.list.next(list);
  }
}
