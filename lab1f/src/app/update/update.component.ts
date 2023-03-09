import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Entity } from '../interfaces/entity';
import { Service1Service } from '../services/service1.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit{


  @Input() entity?:Entity                                      // passing Entity; entity - is used in update binding; we'll be working with this entity
  @Output() updated:EventEmitter<null> = new EventEmitter();   // we need this, for updateEntity
  constructor(private service:Service1Service) {}              // injection, for having access to all it's (Service1Service) methods

  ngOnInit(): void {
  }

  // methods of another class can be named the same
  updateEntity(){
    if (this.entity) {
      console.log(this.entity);
      this.service.putEntity(this.entity).subscribe(
        ()=>{ 
          this.updated.emit();                                    // saying to higher component, that event updated was done 
        }
      );
    }
    

  }
  

}
