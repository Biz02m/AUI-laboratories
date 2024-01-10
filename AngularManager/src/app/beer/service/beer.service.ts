import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Beers } from "../model/beers";
import { Observable } from "rxjs";
import { BeerDetails } from "../model/beer-details";
import { BeerForm } from "../model/beer-form";

@Injectable()
export class BeerService {
  /**
   * @param http HTTP client
   */
  constructor(private http:HttpClient) {

  }

  /**
   * Fetches all beers.
   *
   * @return list of beers
   */
  getBeers(): Observable<Beers> {
    return this.http.get<Beers>('/api/beers');
  }

  /**
   * Fetches single beer.
   *
   * @param uuid beer's id
   * @return single beer
   */
  getBeer(uuid: string): Observable<BeerDetails> {
    return this.http.get<BeerDetails>('/api/beers/' + uuid);
  }

  /**
   * Removes single beer.
   *
   * @param uuid beer's id
   */
  deleteBeer(uuid: string): Observable<any> {
    return this.http.delete('/api/beers/' + uuid);
  }

  /**
   * Updates single beer.
   *
   * @param uuid beer's id
   * @param request request body
   */
  putBeer(uuid: string, request: BeerForm): Observable<any> {
    return this.http.put('/api/beers/' + uuid, request);
  }
}
