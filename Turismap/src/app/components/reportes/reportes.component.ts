import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarLugarturisticoComponent } from "../lugarturistico/listar-lugarturistico/listar-lugarturistico.component";
import { BaseChartDirective } from 'ng2-charts';

import { Chart, registerables } from 'chart.js';
Chart.register(...registerables);
@Component({
  selector: 'app-reportes',
  standalone: true,
  imports: [RouterOutlet, ListarLugarturisticoComponent, BaseChartDirective],
  templateUrl: './reportes.component.html',
  styleUrl: './reportes.component.css'
})
export class ReportesComponent {
  constructor(public route: ActivatedRoute){}
}