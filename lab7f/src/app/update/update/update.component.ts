import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { Bags } from 'src/app/interfaces/bags';
import { Service1Service } from 'src/app/services/service1.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit{

  @Input() entity?:Bags
  @Output() updated:EventEmitter<null> = new EventEmitter();

  constructor(private service:Service1Service) {}

  ngOnInit(): void {
    
  }

  updateEntities(){
    if(this.entity){
      this.service.putBags(this.entity).subscribe(
        ()=>{this.updated.emit();}
      );
    }
    this.refreshPage();
  }

  refreshPage(): void{
    window.location.reload();
  }

}
