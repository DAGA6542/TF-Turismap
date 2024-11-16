import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarLugarTuristicoPorCiudadComponent } from './listar-lugar-turistico-por-ciudad/listar-lugar-turistico-por-ciudad.component';
import { ListarNumeroDeLugarTuristicoComponent } from './listar-numero-de-lugar-turistico/listar-numero-de-lugar-turistico.component';
import { ListarLugarturisticoComponent } from "../lugarturistico/listar-lugarturistico/listar-lugarturistico.component";

@Component({
  selector: 'app-reportes',
  standalone: true,
  imports: [RouterOutlet, ListarLugarturisticoComponent],
  templateUrl: './reportes.component.html',
  styleUrl: './reportes.component.css'
})
export class ReportesComponent {
  constructor(public route: ActivatedRoute){}
}
