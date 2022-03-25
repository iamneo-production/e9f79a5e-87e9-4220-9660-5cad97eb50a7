import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/classModels/user';
import { SignupUserService } from 'src/app/services/signup-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

 user : User = new User();
  constructor(private _userService : SignupUserService, private _router: Router) { }

  ngOnInit(): void {
  }

  loginUser(){
    this._userService.loginUser(this.user)
    .subscribe(data=>{
      localStorage.setItem("userRole", JSON.stringify(data));
    alert("loggedin sucessfully");
    localStorage.setItem("user",JSON.stringify(this.user));
    if(data=="admin"){
      this._router.navigate(["/admin/addMenu"]);
    }
    else{
      this._router.navigate(["/user/getAllThemes"]);
    }},
    error=>{console.log(error)})
  }

}