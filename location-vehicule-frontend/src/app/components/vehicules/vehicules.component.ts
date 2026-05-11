import { Component, OnInit } from '@angular/core';
import { VehiculeService } from '../../services/vehicule.service';

@Component({
  selector: 'app-vehicules',
  templateUrl: './vehicules.component.html'
})
export class VehiculesComponent implements OnInit {
  vehicules: any = [];

  constructor(private service: VehiculeService) { }

  ngOnInit(): void {
    this.service.getVehiculesDisponibles().subscribe({
      next: (data) => { this.vehicules = data; },
      error: (err) => { console.log(err); }
    });
  }
}
