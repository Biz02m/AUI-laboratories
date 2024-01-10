import {Component, OnInit} from '@angular/core';
import {BeerForm} from "../../model/beer-form";
import {TypeOfBeers} from "../../../typeOfBeer/model/typeOfBeers";
import {BeerService} from "../../service/beer.service";
import {TypeOfBeerService} from "../../../typeOfBeer/service/type-of-beer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-beer-edit',
  templateUrl: './beer-edit.component.html',
  styleUrl: './beer-edit.component.css'
})
export class BeerEditComponent implements OnInit{

  /**
   * Beer's id
   */
  uuid: string | undefined;

  /**
   * Single beer
   */
  beer: BeerForm | undefined;

  /**
   * Single beer
   */
  original: BeerForm | undefined;

  /**
   * Available typeOfBeers
   */
  typeOfBeers: TypeOfBeers | undefined;

  /**
   * @param beerService beer service
   * @param typeOfBeerService typeOfBeerService
   * @param route activated route
   * @param router router
   */
  constructor(
    private beerService: BeerService,
    private typeOfBeerService: TypeOfBeerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.typeOfBeerService.getTypeOfBeers()
        .subscribe(typeOfBeers => this.typeOfBeers = typeOfBeers);

      this.beerService.getBeer(params['uuid'])
        .subscribe(beer => {
          this.uuid = beer.id;
          this.beer = {
            name: beer.name,
            percentage: beer.percentage,
            typeOfBeer: params['typeOfBeer']
          };
          this.original = {...this.beer};
        });
    });
  }

  /**
   * Updates ship.
   */
  onSubmit(): void {
    this.beerService.putBeer(this.uuid!, this.beer!)
      .subscribe(() => this.router.navigate(['/beers']));
  }

}
