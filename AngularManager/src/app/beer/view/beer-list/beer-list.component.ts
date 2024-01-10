import {Component, OnInit} from '@angular/core';
import {BeerService} from "../../service/beer.service";
import {Beers} from "../../model/beers";
import {Beer} from "../../model/beer";

@Component({
  selector: 'app-beer-list',
  templateUrl: './beer-list.component.html',
  styleUrl: './beer-list.component.css'
})
export class BeerListComponent implements OnInit{

  /**
   * @param service beers service
   */
  constructor(private service: BeerService) {
  }

  /**
   * Available beers.
   */
  beers: Beers | undefined;

  ngOnInit(): void {
    this.service.getBeers().subscribe(beers => this.beers = beers);
  }

  /**
   * Deletes selected beer.
   *
   * @param beer to be removed
   */
  onDelete(beer: Beer): void {
    this.service.deleteBeer(beer.id).subscribe(() => this.ngOnInit());
  }
}
