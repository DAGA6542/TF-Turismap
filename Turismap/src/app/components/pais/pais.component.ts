import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarPaisComponent } from './listar-pais/listar-pais.component';

@Component({
  selector: 'app-pais',
  standalone: true,
  imports: [RouterOutlet, ListarPaisComponent],
  templateUrl: './pais.component.html',
  styleUrl: './pais.component.css'
})
export class PaisComponent {
  constructor(public route: ActivatedRoute){}
}
