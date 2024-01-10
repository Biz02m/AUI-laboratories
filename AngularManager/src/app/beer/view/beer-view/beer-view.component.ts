import {Component, OnInit} from '@angular/core';
import {BeerDetails} from "../../model/beer-details";
import {BeerService} from "../../service/beer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-beer-view',
  templateUrl: './beer-view.component.html',
  styleUrl: './beer-view.component.css'
})
export class BeerViewComponent implements OnInit{

  /**
   * Single beer.
   */
  beer: BeerDetails | undefined;

  /**
   *
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
      this.service.getBeer(params['uuid'])
        .subscribe(beer => this.beer = beer)
    });
  }

}
