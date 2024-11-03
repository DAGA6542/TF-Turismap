import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarMenbresiavipComponent } from './listar-menbresiavip/listar-menbresiavip.component';

@Component({
  selector: 'app-menbresiavip',
  standalone: true,
  imports: [RouterOutlet, ListarMenbresiavipComponent],
  templateUrl: './menbresiavip.component.html',
  styleUrl: './menbresiavip.component.css'
})
export class MenbresiavipComponent {
  constructor(public route: ActivatedRoute) {}
}
