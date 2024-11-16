import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarDepartamentoComponent } from './listar-departamento/listar-departamento.component';

@Component({
  selector: 'app-departamento',
  standalone: true,
  imports: [RouterOutlet, ListarDepartamentoComponent],
  templateUrl: './departamento.component.html',
  styleUrl: './departamento.component.css'
})
export class DepartamentoComponent {
  constructor(public route: ActivatedRoute){}
}
