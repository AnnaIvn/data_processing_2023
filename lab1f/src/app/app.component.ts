import { Component } from '@angular/core';
import { Entity } from './interfaces/entity';
import { Service1Service } from './services/service1.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  entityList:Entity[]=[];    // entity array, that we'll recieve from our service

  // from services folder
  constructor(private service:Service1Service){}

  getEntities():void{
    this.service.getEntities().subscribe(
      (entities)=>{
        this.entityList=entities;    // this will overwrite empty entityList with recieved entities
      }
    )
  }

}
