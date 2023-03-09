import { Component, OnInit } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit{

  title:string="List of sleeping bags";   // title of the list (shown in html)
  entitiesList:Entity[]=[];
  showAddForm:boolean=false;              // value for showing/hiding form
  selectedEntity?:Entity;                 // value for initialising spesific entity, when clicking on it 

  constructor(private service:Service1Service) {}

  ngOnInit(): void {
    this.updateEntities();
  }

  updateEntities(){
    this.service.getEntities().subscribe(
      (entities)=>{                            // підписка, щось робимо з отриманими даними
        this.entitiesList = entities;          //  привласнюємо отриманий список до entities, за доп. цього - виводиться інфа
      }
    );
  }

  addEntity(entity:Entity){                    // need argument (entity) for postEntity
    this.service.postEntity(entity).subscribe(
      (entity)=>{ 
        console.log(entity);                   // output to the console
        this.updateEntities();                 // calling method for updating entities          
      }
    );
  }

  onSelect(entity:Entity){
    if (this.selectedEntity && entity.name==this.selectedEntity.name){    // if bag was selected
      this.selectedEntity=undefined;    // знімаємо виділення, setting selectedEntity to udefined
    }  
    else{
      this.selectedEntity = entity;     // інакше, setected entity = entity, that we selected
    } 
  }

  deleteEntity(entity:Entity){                    // metod for deletion user from list
    this.service.deleteEntity(entity).subscribe(  // через subscribe ми підпислися до методу deleteEntity, що прописаний в services
      ()=>{ 
        this.updateEntities();                 // оновлюємо наш список, щоб зберегти зміни          
      }
    );
  }

}
