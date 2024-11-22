import { Component, OnInit } from '@angular/core';
import { Chart, ChartDataset, ChartOptions, ChartType, registerables } from 'chart.js';
import { BaseChartDirective } from 'ng2-charts';
import { RolService } from '../../../services/rol.service';
Chart.register(...registerables);
@Component({
  selector: 'app-cantidad-roles',
  standalone: true,
  imports: [BaseChartDirective],
  templateUrl: './cantidad-roles.component.html',
  styleUrl: './cantidad-roles.component.css'
})
export class CantidadRolesComponent implements OnInit{
  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartLabels: string[] = [];
  barChartType: ChartType = 'pie';
  barChartLegend = true;
  barChartData: ChartDataset[] = [];

  constructor(private crS: RolService) {}
  ngOnInit(): void {
    this.crS.obtenerUsuariosxRol().subscribe((data) => {
      this.barChartLabels = data.map((item) => item.nombreRol);
      this.barChartData = [
        {
          data: data.map((item) => item.cantidadUsuario),
          label: 'Cantidad de usuarios por rol',
          backgroundColor: ['#FF0000', '#ffac33', '#FF6347', '#FF7F50'],
          borderColor:'rgba(173,216,230,1)',
          borderWidth:1
        },
      ];
    });
  }

}
