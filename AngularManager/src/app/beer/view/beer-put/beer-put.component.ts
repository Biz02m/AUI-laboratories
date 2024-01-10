import { Component } from '@angular/core';
import { v4 as uuidv4 } from 'uuid';
import {BeerForm} from "../../model/beer-form";
import {Beers} from "../../model/beers";
import {BeerService} from "../../service/beer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-beer-put',
  templateUrl: './beer-put.component.html',
  styleUrl: './beer-put.component.css'
})
export class BeerPutComponent {

  /**
   * Single beer.
   */
  beer: BeerForm | undefined;
  beers: Beers | undefined;

  /**
   * @param service beer service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: BeerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.beer = {
        name: "enter name",
        percentage: 0,
        typeOfBeer: params['uuid']
      };

      this.service.getBeers().subscribe(beers => this.beers = beers);
    });

    this.service.getBeers().subscribe(beers => this.beers = beers);
  }

  /**
   * Updates beer.
   */
  onSubmit(): void {
    let uuid = ""
    let rand:boolean = false
    do {
      uuid = uuidv4()
      rand = false
      for(let i=0; i<this.beers!.beers.length; i++){
        if(uuid==this.beers!.beers[i].id)
        {
          rand = true
        }
      }
    }while (rand)

    this.service.putBeer(uuid, this.beer!)
      .subscribe(() => this.router.navigate(['/typeOfBeers/'+this.beer!.typeOfBeer]));
  }
}
