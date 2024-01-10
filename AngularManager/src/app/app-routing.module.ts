import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TypeOfBeerListComponent} from "./typeOfBeer/view/type-of-beer-list/type-of-beer-list.component";
import {TypeOfBeerEditComponent} from "./typeOfBeer/view/type-of-beer-edit/type-of-beer-edit.component";
import {TypeOfBeerPutComponent} from "./typeOfBeer/view/type-of-beer-put/type-of-beer-put.component";
import {BeerListComponent} from "./beer/view/beer-list/beer-list.component";
import {BeerEditComponent} from "./beer/view/beer-edit/beer-edit.component";
import {TypeOfBeerViewComponent} from "./typeOfBeer/view/type-of-beer-view/type-of-beer-view.component";
import {BeerPutComponent} from "./beer/view/beer-put/beer-put.component";
import {BeerViewComponent} from "./beer/view/beer-view/beer-view.component";

const routes: Routes = [
  {
    component: TypeOfBeerPutComponent,
    path: "typeOfBeers/create"
  },
  {
    component: TypeOfBeerListComponent,
    path: "typeOfBeers"
  },
  {
    component: TypeOfBeerEditComponent,
    path: "typeOfBeers/:uuid/edit"
  },
  {
    component: BeerListComponent,
    path: "beers"
  },
  {
    component: BeerEditComponent,
    path: "typeOfBeers/:typeOfBeer/beers/:uuid/edit"
  },
  {
    component: TypeOfBeerViewComponent,
    path: "typeOfBeers/:uuid"
  },
  {
    component: BeerPutComponent,
    path: "typeOfBeers/:uuid/beers/create"
  },
  {
    component: BeerViewComponent,
    path: "typeOfBeers/:typeOfBeer/beers/:uuid"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
