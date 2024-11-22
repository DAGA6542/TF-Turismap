import { Component } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterOutlet } from '@angular/router';
import { ListarCiudadComponent } from './listar-ciudad/listar-ciudad.component';
@Component({
  selector: 'app-ciudad',
  standalone: true,
  imports: [RouterOutlet , ListarCiudadComponent],
  templateUrl: './ciudad.component.html',
  styleUrl: './ciudad.component.css'
})
export class CiudadComponent {
  constructor(public route: ActivatedRoute) {}
}
