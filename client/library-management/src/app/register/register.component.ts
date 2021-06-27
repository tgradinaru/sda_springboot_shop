import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  login = ''
  password = ''
  confirmPassword = ''
  email = ''
  terms = true

  constructor(private router:Router,
              private loginservice:HardcodedAuthenticationService) { }

  ngOnInit() {
  }

  handleRegister()
  {
    this.loginservice.register(this.login,this.password, this.confirmPassword, this.email, this.terms)
  }

}
