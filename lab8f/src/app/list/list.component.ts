import { Component, OnInit } from '@angular/core';
import { Bags } from 'src/app/interfaces/bags';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})

export class ListComponent implements OnInit{
  
  //title:string="List of your favourite bags";
  entityList:Bags[]=[];
  showAddForm:boolean=false;
  selectedEntity?:Bags;

  constructor(private service:Service1Service) {}

  ngOnInit(): void{
    this.updateEntities();
    this.service.list.subscribe(
      (list:Bags[])=>{this.entityList=list}
    );
  }

  updateEntities(){
    this.service.getBags().subscribe(
      (entities)=>{
        this.service.setList(entities);
      }
    );
  }

  addEntities(entity:Bags){
    this.service.postBags(entity).subscribe(
      (entities)=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  onSelect(entity:Bags){
    if(this.selectedEntity && entity.id==this.selectedEntity.id){
      this.selectedEntity=undefined;
    } else{
      this.selectedEntity=entity;
    }
  }

  deleteEntities(entity:Bags){
    this.service.deleteBags(entity).subscribe(
      ()=>{
        this.updateEntities();
      }
    );
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }
}

