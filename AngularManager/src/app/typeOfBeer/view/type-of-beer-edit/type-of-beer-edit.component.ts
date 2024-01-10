import { Component, OnInit } from '@angular/core';
import {TypeOfBeerForm} from "../../model/typeOfBeer-form";
import {TypeOfBeerService} from "../../service/type-of-beer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-type-of-beer-edit',
  templateUrl: './type-of-beer-edit.component.html',
  styleUrl: './type-of-beer-edit.component.css'
})
export class TypeOfBeerEditComponent implements OnInit{

  /**
   * TypeOfBeer's id.
   */
  uuid: string | undefined;

  /**
   * Single typeOfBeer.
   */
  typeOfBeer: TypeOfBeerForm | undefined;

  /**
   * Single typeOfBeer.
   */
  original: TypeOfBeerForm | undefined;

  /**
   * @param service typeOfBeer service
   * @param route activated route
   * @param router router
   */
  constructor(
    private service: TypeOfBeerService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getTypeOfBeer(params['uuid'])
        .subscribe(typeOfBeer => {
          this.uuid = typeOfBeer.id;
          this.typeOfBeer = {
            typeOfBeerName: typeOfBeer.typeOfBeerName,
            yearOfInvention: typeOfBeer.yearOfInvention,
          };
          this.original = {...this.typeOfBeer};
        });
    });
  }

  /**
   * Updates TypeOfBeer
   */
  onSubmit(): void {
    this.service.putTypeOfBeer(this.uuid!, this.typeOfBeer!)
      .subscribe(() => this.router.navigate(['/typeOfBeers']));
  }
}
