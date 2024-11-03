import { Component } from '@angular/core';
import { ListarRolComponent } from "./listar-rol/listar-rol.component";
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-rol',
  standalone: true,
  imports: [RouterOutlet ,ListarRolComponent],
  templateUrl: './rol.component.html',
  styleUrl: './rol.component.css'
})
export class RolComponent {
  constructor(public route: ActivatedRoute) {}
}
