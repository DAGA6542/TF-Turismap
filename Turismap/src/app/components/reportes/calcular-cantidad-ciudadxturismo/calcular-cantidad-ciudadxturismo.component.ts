import { Component, OnInit } from '@angular/core';
import { Chart, ChartDataset, ChartOptions, ChartType, registerables } from 'chart.js';
import { CiudadService } from '../../../services/ciudad.service';
import { BaseChartDirective } from 'ng2-charts';

Chart.register(...registerables);
@Component({
  selector: 'app-calcular-cantidad-ciudadxturismo',
  standalone: true,
  imports: [BaseChartDirective],
  templateUrl: './calcular-cantidad-ciudadxturismo.component.html',
  styleUrl: './calcular-cantidad-ciudadxturismo.component.css'
})
export class CalcularCantidadCiudadxturismoComponent implements OnInit{
  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartLabels: string[] = [];
  barChartType: ChartType = 'doughnut';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(private cS: CiudadService) {}
  ngOnInit(): void {
    this.cS.obtenerCantidadTurismoxCiudad().subscribe((data) => {
      this.barChartLabels = data.map((item) => item.nombreCiudad);
      this.barChartData = [
        {
          data: data.map((item) => item.cantidadTurismoxCiudad),
          label: 'Cantidad de lugares turisticos por ciudad',
          backgroundColor: ['#FF0000', '#ffac33', '#FF6347', '#FF7F50'],
          borderColor:'rgba(173,216,230,1)',
          borderWidth:1
        },
      ];
    });
  }
}
