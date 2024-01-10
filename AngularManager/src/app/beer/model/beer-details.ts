import { TypeOfBeer } from "../../typeOfBeer/model/typeOfBeer";

/**
 * Represents single beer in list.
 */
export interface BeerDetails {

  /**
   * Unique id identifying beer.
   */
  id: string;

  /**
   * Name of the beer.
   */
  name: string;

  percentage: number;

  /**
   * type of beer.
   */
  typeOfBeer: TypeOfBeer;

}
