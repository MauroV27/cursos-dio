import { Component, Input, OnInit } from '@angular/core';
import {RouterModule} from '@angular/router';
import { CardData } from '../../model/card-data';

@Component({
  selector: 'app-big-card',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './big-card.component.html',
  styleUrl: './big-card.component.css'
})
export class BigCardComponent implements OnInit {

  @Input() data: CardData| undefined

  photoCover:string =""
  cardTitle:string = ""
  cardDescription:string =""
  Id:string = ""

  constructor() { }

  ngOnInit(): void {

    if ( this.data != undefined ){
      this.Id = this.data?.id;
      this.photoCover = this.data?.image_url;
      this.cardTitle = this.data?.title
      this.cardDescription = this.data?.description
    } 

  }

}
