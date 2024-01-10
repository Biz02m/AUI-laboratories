import {Component, OnInit} from '@angular/core';
import {TypeOfBeerForm} from "../../model/typeOfBeer-form";
import {TypeOfBeers} from "../../model/typeOfBeers";
import {TypeOfBeerService} from "../../service/type-of-beer.service";
import {ActivatedRoute, Router} from "@angular/router";
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-type-of-beer-put',
  templateUrl: './type-of-beer-put.component.html',
  styleUrl: './type-of-beer-put.component.css'
})
export class TypeOfBeerPutComponent implements OnInit{

  typeOfBeer: TypeOfBeerForm | undefined;
  typeOfBeers: TypeOfBeers | undefined;

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
    this.typeOfBeer = {
      typeOfBeerName: "enter name",
      yearOfInvention: 1900,
    }
    this.service.getTypeOfBeers().subscribe(typeOfBeers => this.typeOfBeers = typeOfBeers)
  }

  onSubmit(): void {
    let uuid = ""
    let rand:boolean = false
    do {
      uuid = uuidv4()
      rand = false
      for(let i=0; i<this.typeOfBeers!.typeOfBeers.length; i++){
        if(uuid==this.typeOfBeers!.typeOfBeers[i].id)
        {
          rand = true
        }
      }
    }while (rand)

    this.service.putTypeOfBeer(uuid, this.typeOfBeer!)
      .subscribe(() => this.router.navigate(['/typeOfBeers']));
  }

}
