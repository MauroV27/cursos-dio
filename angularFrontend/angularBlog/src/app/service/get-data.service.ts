import { Injectable } from '@angular/core';
import fakeData from '../../../public/data/fake-data.json';
import { CardData } from '../model/card-data';

@Injectable({
  providedIn: 'root'
})
export class GetDataService {

  constructor() { }

  getAllDataFromAPI() : any {
    return fakeData;
  }

  getDataFromAPI(index:string) : CardData {
    return fakeData.filter( value => value.id === index )[0];
  }
}
