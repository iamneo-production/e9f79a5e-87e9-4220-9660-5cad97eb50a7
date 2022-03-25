import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/classModels/user';
import { SignupUserService } from 'src/app/services/signup-user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user : User = new User();
  constructor(private _signupService : SignupUserService, private _router: Router) { }

  ngOnInit(): void {
  }

  changeUrltoUser(){
    this._router.navigate(["/user/signup"]);
  }
  changeUrltoAdmin(){
    this._router.navigate(["/admin/signup"]);
  }

  signupUser(){
    if(this.user.userRole=="user"){
      this._signupService.registerUser(this.user).subscribe(response=>{
        console.log("response")
        alert("Sucessfully User is registered");
        this._router.navigate(["/user/login"]);
      })
    }
    if(this.user.userRole == "admin"){
      this._signupService.registerAdmin(this.user).subscribe(response=>{
        console.log(response);
        alert("Sucessfully Admin is registered");
        this._router.navigate(["/user/login"]);
      },error=>{
        console.log(error);
        alert("sorry Admin is not registered");
      })
    }
   
    
  }
}
