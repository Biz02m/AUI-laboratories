import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TypeOfBeers} from "../model/typeOfBeers";
import {TypeOfBeerDetails} from "../model/typeOfBeer-details";
import {TypeOfBeerForm} from "../model/typeOfBeer-form";
import {Beers} from "../../beer/model/beers";

@Injectable()
export class TypeOfBeerService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all typeOfBeers.
   *
   * @return list of typeOfBeers
   */
  getTypeOfBeers(): Observable<TypeOfBeers> {
    return this.http.get<TypeOfBeers>('/api/typeOfBeers');
  }

  getTypeOfBeer(uuid: string): Observable<TypeOfBeerDetails> {
    return this.http.get<TypeOfBeerDetails>('/api/typeOfBeers/' + uuid);
  }

  getTypeOfBeerBeers(uuid: string): Observable<Beers>{
    return this.http.get<Beers>('/api/typeOfBeers/' + uuid + '/beers')
  }

  putTypeOfBeer(uuid: string, request: TypeOfBeerForm): Observable<any>{
    return this.http.put('/api/typeOfBeers/' + uuid, request);
  }

  deleteTypeOfBeer(uuid: string): Observable<any>{
    return this.http.delete('/api/typeOfBeers/' + uuid);
  }
}
