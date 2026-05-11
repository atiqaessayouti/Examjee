import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module'; // تأكدي من هادي
import { AppComponent } from './app.component';
import { VehiculesComponent } from './components/vehicules/vehicules.component';

@NgModule({
  declarations: [
    AppComponent,
    VehiculesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
