import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddmenuComponent } from './addmenu/addmenu.component';
import { AddonComponent } from './addon/addon.component';
import { AddthemeComponent } from './addtheme/addtheme.component';
import { BookingComponent } from './booking/booking.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { ViewbookingComponent } from './viewbooking/viewbooking.component';
import { AuthGuard } from './guards/auth.guard';
import { RoleGuardGuard } from './guards/role-guard.guard';

const routes: Routes = [
  {path:'user/signup', component:SignupComponent},

  {path:'admin/signup', component:SignupComponent},

  {path:'admin/login', component:LoginComponent},

  {path:'user/login', component:LoginComponent},

  {path:'user/getAllThemes', component:HomepageComponent,
  canActivate:[AuthGuard, RoleGuardGuard],
  data:{expectedRoles:"user"}},

  {path:'user/bookTheme', component:BookingComponent,
  canActivate:[AuthGuard,RoleGuardGuard],
  data:{expectedRoles:"user"}},

  {path:'user/getBookedTheme', component:ViewbookingComponent,
  canActivate:[AuthGuard,RoleGuardGuard],
  data:{expectedRoles:"user"}},

  {path:'admin/addTheme', component:AddthemeComponent,
  canActivate:[AuthGuard,RoleGuardGuard],
  data:{expectedRoles:"admin"}},

  {path:'admin/addMenu', component: AddmenuComponent,
  canActivate:[AuthGuard,RoleGuardGuard],
  data:{expectedRoles:"admin"}},

  {path:'admin/addOn', component: AddonComponent,
  canActivate:[AuthGuard,RoleGuardGuard],
  data:{expectedRoles:"admin"}},

  {path:"", redirectTo:'/user/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
