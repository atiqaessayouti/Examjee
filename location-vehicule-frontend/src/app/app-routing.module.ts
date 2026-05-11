import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehiculesComponent } from './components/vehicules/vehicules.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: 'vehicules', component: VehiculesComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/vehicules', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
