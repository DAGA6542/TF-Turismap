import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarLugarturisticoComponent } from './listar-lugarturistico/listar-lugarturistico.component';

@Component({
  selector: 'app-lugarturistico',
  standalone: true,
  imports: [RouterOutlet, ListarLugarturisticoComponent],
  templateUrl: './lugarturistico.component.html',
  styleUrl: './lugarturistico.component.css'
})
export class LugarturisticoComponent {
  constructor(public route: ActivatedRoute) {}
}
