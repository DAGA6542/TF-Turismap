import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarFavoritoComponent } from './listar-favorito/listar-favorito.component';

@Component({
  selector: 'app-favorito',
  standalone: true,
  imports: [RouterOutlet, ListarFavoritoComponent],
  templateUrl: './favorito.component.html',
  styleUrl: './favorito.component.css'
})
export class FavoritoComponent {
  constructor(public route: ActivatedRoute){}
}
