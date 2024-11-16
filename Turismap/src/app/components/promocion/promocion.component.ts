import { Component } from '@angular/core';
import { ListarPromocionComponent } from "./listar-promocion/listar-promocion.component";
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-promocion',
  standalone: true,
  imports: [RouterOutlet ,ListarPromocionComponent],
  templateUrl: './promocion.component.html',
  styleUrl: './promocion.component.css'
})
export class PromocionComponent {
  constructor(public route: ActivatedRoute) {}
}
