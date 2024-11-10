import { Component, OnInit } from '@angular/core';
import { MenuTitleComponent } from '../../components/menu-title/menu-title.component';
import { BigCardComponent } from '../../components/big-card/big-card.component';
import { SmallCardComponent } from '../../components/small-card/small-card.component';
import { GetDataService } from '../../service/get-data.service';
import { CardData } from '../../model/card-data';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MenuTitleComponent,
    BigCardComponent, 
    SmallCardComponent,
    CommonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  mainCardData : CardData | undefined
  smallCards : CardData[] | undefined

  constructor( private api:GetDataService ){
    
  }
 
  ngOnInit(): void {

    this.mainCardData = this.api.getDataFromAPI("1");

    this.smallCards = this.api.getAllDataFromAPI().filter( (v:CardData, i:number) => i > 0 );
  }

}
