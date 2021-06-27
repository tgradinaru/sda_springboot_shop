import {Injectable} from '@angular/core';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  model: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) {
  }

  ngOnInit() {
    sessionStorage.setItem('token', '');
  }

  authenticate(username, password) {
    let url = 'http://localhost:8081/api/login';
    this.http.post<Observable<boolean>>(url, {
      login: username,
      password: password
    }).subscribe(isValid => {
      if (isValid) {
        sessionStorage.setItem('token', btoa(username + ':' + password));
        this.router.navigate(['welcome', username])
      } else {
        alert("Authentication failed.")
      }
    });
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('token')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('token')
  }


  register(login: string, password: string, confirmPassword: string, email: string, terms: boolean) {
    let url = 'http://localhost:8081/api/user/register';
    this.http.post<Observable<boolean>>(url, {
      login: login,
      password: password,
      confirmPassword: confirmPassword,
      email: email,
      terms: terms
    }).subscribe(isValid => {
      if (isValid) {
        this.router.navigate(['login'])
      } else {
        alert("Register failed.")
      }
    });
  }
}
