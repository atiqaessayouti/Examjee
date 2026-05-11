import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class VehiculeService {
  private host = "http://localhost:8081/api/vehicules";

  constructor(private http: HttpClient) { }

  public getVehiculesDisponibles(): Observable<any> {
    return this.http.get(`${this.host}/disponibles`);
  }
}
