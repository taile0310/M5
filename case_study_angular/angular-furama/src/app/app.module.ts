import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FoosterComponent } from './fooster/fooster.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListFacilityComponent } from './list-facility/list-facility.component';
import { AddNewFacilityComponent } from './add-new-facility/add-new-facility.component';
import { UpdateFacilityComponent } from './update-facility/update-facility.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { AddNewCustomerComponent } from './add-new-customer/add-new-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FoosterComponent,
    NavbarComponent,
    ListFacilityComponent,
    AddNewFacilityComponent,
    UpdateFacilityComponent,
    ListCustomerComponent,
    AddNewCustomerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
