import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarNegocioComponent } from './listar-negocio/listar-negocio.component';

@Component({
  selector: 'app-negocio',
  standalone: true,
  imports: [RouterOutlet, ListarNegocioComponent],
  templateUrl: './negocio.component.html',
  styleUrl: './negocio.component.css'
})
export class NegocioComponent {
  constructor(public route: ActivatedRoute) {}
}
