import {Component, OnInit} from '@angular/core';
import {TypeOfBeerDetails} from "../../model/typeOfBeer-details";
import {Beers} from "../../../beer/model/beers";
import {TypeOfBeerService} from "../../service/type-of-beer.service";
import {BeerService} from "../../../beer/service/beer.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Beer} from "../../../beer/model/beer";

@Component({
  selector: 'app-type-of-beer-view',
  templateUrl: './type-of-beer-view.component.html',
  styleUrl: './type-of-beer-view.component.css'
})
export class TypeOfBeerViewComponent implements OnInit {

  typeOfBeer: TypeOfBeerDetails | undefined;
  beers: Beers | undefined;

  /**
   * @param service typeOfBeer service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: TypeOfBeerService,
    private beerService: BeerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getTypeOfBeer(params['uuid']).subscribe(typeOfBeer => this.typeOfBeer = typeOfBeer);
      this.service.getTypeOfBeerBeers(params['uuid']).subscribe(beers => this.beers = beers)
    });
  }

  onDelete(beer: Beer): void {
    this.beerService.deleteBeer(beer.id).subscribe(() => this.ngOnInit());
  }

}
