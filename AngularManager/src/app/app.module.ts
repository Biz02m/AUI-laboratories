import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './component/main/main.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { TypeOfBeerListComponent } from './typeOfBeer/view/type-of-beer-list/type-of-beer-list.component';
import {TypeOfBeerService} from "./typeOfBeer/service/type-of-beer.service";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { TypeOfBeerEditComponent } from './typeOfBeer/view/type-of-beer-edit/type-of-beer-edit.component';
import { TypeOfBeerPutComponent } from './typeOfBeer/view/type-of-beer-put/type-of-beer-put.component';
import { TypeOfBeerViewComponent } from './typeOfBeer/view/type-of-beer-view/type-of-beer-view.component';
import { BeerListComponent } from './beer/view/beer-list/beer-list.component';
import {BeerService} from "./beer/service/beer.service";
import { BeerEditComponent } from './beer/view/beer-edit/beer-edit.component';
import { BeerPutComponent } from './beer/view/beer-put/beer-put.component';
import { BeerViewComponent } from './beer/view/beer-view/beer-view.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    NavComponent,
    TypeOfBeerListComponent,
    TypeOfBeerEditComponent,
    TypeOfBeerPutComponent,
    TypeOfBeerViewComponent,
    BeerListComponent,
    BeerEditComponent,
    BeerPutComponent,
    BeerViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    TypeOfBeerService,
    BeerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
