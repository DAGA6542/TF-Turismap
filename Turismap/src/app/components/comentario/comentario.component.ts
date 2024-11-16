import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarComentarioComponent } from './listar-comentario/listar-comentario.component';

@Component({
  selector: 'app-comentario',
  standalone: true,
  imports: [RouterOutlet, ListarComentarioComponent],
  templateUrl: './comentario.component.html',
  styleUrl: './comentario.component.css'
})
export class ComentarioComponent {
  constructor(public route: ActivatedRoute){}
}
