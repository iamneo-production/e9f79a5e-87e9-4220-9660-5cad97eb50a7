import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoleGuardGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // return true;
      
      const {expectedRoles} = route.data;
    
      console.log(expectedRoles)
      let str= localStorage.getItem("userRole")
      const removed = str?.replace(/"/g, '');
      if(removed==="user"){
        if(expectedRoles==="user"){
          return true;
        }
        return false;
      }
      else{
        if(expectedRoles === "admin"){
          return true;
        }
        else{
          return false;
        }
      }

  }


  
}
