import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list'; // Importación del módulo MatListModule
import { UsuarioComponent } from './components/usuario/usuario.component';
import { PromocionComponent } from './components/promocion/promocion.component';
import { PaisComponent } from './components/pais/pais.component';
import { CiudadComponnent } from './components/ciudad/ciudad.component';
import { ComentarioComponent } from './components/comentario/comentario.component';
import { DepartamentoComponent } from './components/departamento/departamento.component';
import { FavoritoComponent } from './components/favorito/favorito.component';
import { FestividadComponent } from './components/festividad/festividad.component';
import { LugarturisticoComponent } from './components/lugarturistico/lugarturistico.component';
import { MenbresiavipComponent } from './components/menbresiavip/menbresiavip.component';
import { NegocioComponent } from './components/negocio/negocio.component';
import { RolComponent } from './components/rol/rol.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    UsuarioComponent,
    PromocionComponent,
    PaisComponent,
    CiudadComponnent,
    ComentarioComponent,
    DepartamentoComponent,
    FavoritoComponent,
    FestividadComponent,
    LugarturisticoComponent,
    MenbresiavipComponent,
    NegocioComponent,
    RolComponent,
    MatToolbarModule,
    RouterLink,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatExpansionModule,
    MatSidenavModule,
    MatListModule 
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Turismap';
}
