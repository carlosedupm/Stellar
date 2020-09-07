import { User } from './user';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  // tslint:disable-next-line: typedef
  public signIn(userData: User) {
    localStorage.setItem('ACCESS_TOKEN', 'access_token');
  }
  // tslint:disable-next-line: typedef
  public isLoggedIn(){
    return localStorage.getItem('ACCESS_TOKEN') !== null;
  }
   // tslint:disable-next-line: typedef
  public logout(){
    localStorage.removeItem('ACCESS_TOKEN');
  }
}
