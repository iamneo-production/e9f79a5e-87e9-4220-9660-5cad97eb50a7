import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignupComponent } from './auth/signup/signup.component';
import { LoginComponent } from './auth/login/login.component';
import { FormsModule } from '@angular/forms';
import { HomepageComponent } from './homepage/homepage.component';
import { BookingComponent } from './booking/booking.component';
import { ViewbookingComponent } from './viewbooking/viewbooking.component';
import { AddthemeComponent } from './addtheme/addtheme.component';
import { AddmenuComponent } from './addmenu/addmenu.component';
import {HttpClientModule} from '@angular/common/http'
import { AuthGuard } from './guards/auth.guard';
import { RoleGuardGuard } from './guards/role-guard.guard';
import { AddonComponent } from './addon/addon.component';

@NgModule({
  declarations: [ 
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomepageComponent,
    BookingComponent,
    ViewbookingComponent,
    AddthemeComponent,
    AddmenuComponent,
    AddonComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthGuard, RoleGuardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
