import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CardData } from '../../model/card-data';

@Component({
  selector: 'app-small-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './small-card.component.html',
  styleUrl: './small-card.component.css'
})
export class SmallCardComponent implements OnInit{

  @Input() data : CardData | undefined 

  photoCover:string = ""
  cardTitle:string = ""
  Id:string=""

  constructor() { }

  ngOnInit(): void {
    if ( this.data != undefined ){
      this.Id = this.data?.id;
      this.photoCover = this.data?.image_url;
      this.cardTitle = this.data?.title

      console.log(this.data)
    } 


  }

}
