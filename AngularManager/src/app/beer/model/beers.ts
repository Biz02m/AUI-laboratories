import { Beer } from "./beer";

/**
 * GET beers response. Contains list of available beers. Can be used to list particular user's beers as
 * well as all beers in the game.
 */
export interface Beers {

  /**
   * Name of the selected ships.
   */
  beers:Beer[];

}
