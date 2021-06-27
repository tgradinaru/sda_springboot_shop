import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'sdatest'
  password = ''
  invalidLogin=false

  constructor(private router:Router,
    private loginservice:HardcodedAuthenticationService) { }

  ngOnInit() {
  }

  handleLogin()
  {
    //console.log(this.username);
    this.loginservice.authenticate(this.username,this.password)
  }

}
