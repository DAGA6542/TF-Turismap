import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
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
import { LoginService } from './services/login.service';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, UsuarioComponent, PromocionComponent, PaisComponent,
    CiudadComponnent, ComentarioComponent, DepartamentoComponent, FavoritoComponent, FestividadComponent,
    LugarturisticoComponent, MenbresiavipComponent, NegocioComponent, MatToolbarModule, RouterLink,
    RolComponent, MatMenuModule, MatIconModule, MatButtonModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Turismap';
  role: string = '';
  constructor(private loginService: LoginService) {}
  cerrar() {
    sessionStorage.clear();
  }

  verificar() {
    this.role = this.loginService.showRole();
    return this.loginService.verificar();
  }
  isAdmin() {
    return this.role === 'ADMIN';
  }

  isViajero() {
    return this.role === 'VIAJERO';
  }
}
