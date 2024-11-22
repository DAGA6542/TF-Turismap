import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ListarLugarturisticoComponent } from './listar-lugarturistico/listar-lugarturistico.component';
import { url } from 'node:inspector';
import { environment } from '../../../environments/environments';
import { LugarTuristico } from '../../models/lugarturistico';

@Component({
  selector: 'app-lugarturistico',
  standalone: true,
  imports: [RouterOutlet, ListarLugarturisticoComponent],
  templateUrl: './lugarturistico.component.html',
  styleUrl: './lugarturistico.component.css'
})
export class LugarturisticoComponent {

  lugar:LugarTuristico=new LugarTuristico();

  constructor(public route: ActivatedRoute) {
   
  }

  }

