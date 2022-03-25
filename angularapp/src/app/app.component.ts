import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'Demo';
  user = localStorage.getItem('user');

  isUserLoggedIn(){

    // console.log("u: ",localStorage.getItem("userRole"))
    let str= localStorage.getItem("userRole")
    const removed = str?.replace(/"/g, '');
    if(localStorage.getItem("user")&& removed==="user"){
      // console.log("t-u")
      return true;
    }
    else{
      // console.log("f-u")

      return false;
    }
  }

  isAdminLoggedIn(){
    // console.log("a: ",localStorage.getItem("userRole"))
    let str= localStorage.getItem("userRole")
    const removed = str?.replace(/"/g, '');
  // console.log( localStorage.getItem('userRole'),`${"admin"}`)
    if((localStorage.getItem("user")!==null) &&removed=="admin"){
      // console.log("t-a")

      return true;
    }
    else{
      // console.log("f-a")

      return false;
    }
  }
  logout(){
    localStorage.clear();
  }
}
