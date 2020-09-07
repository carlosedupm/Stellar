import { AuthService } from './../../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) { }

  authForm: FormGroup;
  isSubmitted  =  false;

  ngOnInit(): void {
    this.authForm  =  this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
  });
}
// tslint:disable-next-line: typedef
get formControls() { return this.authForm.controls; }
// tslint:disable-next-line: typedef
signIn(){
  this.isSubmitted = true;
  if ( this.authForm.invalid){
    return;
  }
  this.authService.signIn(this.authForm.value);
  this.router.navigateByUrl('/admin');
}

}
