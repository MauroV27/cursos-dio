import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { GetDataService } from '../../service/get-data.service';

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './content.component.html',
  styleUrl: './content.component.css'
})
export class ContentComponent {

  photoCover:string = ""
  contentTitle:string = ""
  contentDescription:string = ""
  private id:string | null = null

  constructor(
    private route:ActivatedRoute,
    private api: GetDataService
  ) { }

  ngOnInit(): void {
 
    this.route.paramMap.subscribe( value =>
      this.id  = value.get("id")
    )

    this.id = this.id ? this.id : "";

    this.setValuesToComponent(this.id)
  }

  setValuesToComponent(id:string){
    const result = this.api.getDataFromAPI(id);

    this.contentTitle = result.title;
    this.contentDescription = result.description;
    this.photoCover = result.image_url;
  }

}
