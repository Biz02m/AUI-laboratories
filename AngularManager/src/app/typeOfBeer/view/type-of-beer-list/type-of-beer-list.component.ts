import { Component, OnInit } from '@angular/core';
import { TypeOfBeer } from "../../model/typeOfBeer";
import { TypeOfBeers } from "../../model/typeOfBeers";
import { TypeOfBeerService } from "../../service/type-of-beer.service";

@Component({
  selector: 'app-type-of-beer-list',
  templateUrl: './type-of-beer-list.component.html',
  styleUrl: './type-of-beer-list.component.css'
})
export class TypeOfBeerListComponent implements OnInit {

  /**
   * @param service typeOfBeers service
   */
  constructor(private service:TypeOfBeerService) {
  }

  /**
   * Available typeOfBeers
   */
  typeOfBeers: TypeOfBeers | undefined;

  ngOnInit(): void {
    this.service.getTypeOfBeers().subscribe(typeOfBeers => this.typeOfBeers = typeOfBeers);
  }

  /**
   * Deletes selected typeOfBeer
   *
   * @param typeOfBeer typeOfBeer to be removed
   */
  onDelete(typeOfBeer: TypeOfBeer): void {
    this.service.deleteTypeOfBeer(typeOfBeer.id).subscribe(() => this.ngOnInit());
  }

}
