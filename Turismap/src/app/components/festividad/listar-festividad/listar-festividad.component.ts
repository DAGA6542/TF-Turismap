import { Component } from '@angular/core';
import { ListarPaisComponent } from '../../pais/listar-pais/listar-pais.component';
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-listar-festividad',
  standalone: true,
  imports: [RouterOutlet, ListarPaisComponent],
  templateUrl: './listar-festividad.component.html',
  styleUrl: './listar-festividad.component.css'
})
export class ListarFestividadComponent {
  constructor(public route: ActivatedRoute){}

}
