import { HttpClient, JsonpClientBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import {User} from '../classModels/user'

@Injectable({
  providedIn: 'root'
})
export class SignupUserService {

  signupUserUrl ="https://8080-ececfbcfdafeeaceeaebabaadabeeadfecdaaaa.examlyiopb.examly.io//user/signup";
  loginUserUrl ="https://8080-ececfbcfdafeeaceeaebabaadabeeadfecdaaaa.examlyiopb.examly.io//user/login";
  signupAdminUrl = "https://8080-ececfbcfdafeeaceeaebabaadabeeadfecdaaaa.examlyiopb.examly.io//admin/signup";
  constructor(private _http : HttpClient) { }

  registerUser(user : User): Observable<any> {
    console.log("hello");
    return this._http.post(`${this.signupUserUrl}`,user, {responseType: 'text'});
  }

  loginUser(user : User): Observable<Object>{
    return this._http.post(`${this.loginUserUrl}`,user,{responseType: 'text'});
  }

  registerAdmin(admin: User):Observable<any>{
    return this._http.post(`${this.signupAdminUrl}`,admin,{responseType: 'text'});
  }
}
