import { Component } from '@angular/core';
import { ListarFestividadComponent } from "./listar-festividad/listar-festividad.component";
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-festividad',
  standalone: true,
  imports: [RouterOutlet, ListarFestividadComponent],
  templateUrl: './festividad.component.html',
  styleUrl: './festividad.component.css'
})
export class FestividadComponent {
  constructor(public route: ActivatedRoute) {}
}
