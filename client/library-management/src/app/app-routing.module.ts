import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {WelcomeComponent} from './welcome/welcome.component';
import {ErrorComponent} from './error/error.component';
import {ListBooksComponent} from './list-books/list-books.component';
import {LogoutComponent} from './logout/logout.component';
import {RouteGaurdService} from './service/route-gaurd.service';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'welcome/:name', component: WelcomeComponent, canActivate: [RouteGaurdService]},
  {path: 'books', component: ListBooksComponent, canActivate: [RouteGaurdService]},
  {path: 'logout', component: LogoutComponent, canActivate: [RouteGaurdService]},
  {path: '**', component: ErrorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
