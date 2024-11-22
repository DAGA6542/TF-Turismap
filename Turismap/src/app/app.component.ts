import { Component, OnInit, ViewChild } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
<<<<<<< .merge_file_pK0wHD
import { UsuarioComponent } from './components/usuario/usuario.component';
import { PromocionComponent } from './components/promocion/promocion.component';
import { PaisComponent } from './components/pais/pais.component';
import { CiudadComponent } from './components/ciudad/ciudad.component';
import { ComentarioComponent } from './components/comentario/comentario.component';
import { DepartamentoComponent } from './components/departamento/departamento.component';
import { FavoritoComponent } from './components/favorito/favorito.component';
import { FestividadComponent } from './components/festividad/festividad.component';
import { LugarturisticoComponent } from './components/lugarturistico/lugarturistico.component';
import { MenbresiavipComponent } from './components/menbresiavip/menbresiavip.component';
import { NegocioComponent } from './components/negocio/negocio.component';
import { RolComponent } from './components/rol/rol.component';
=======
>>>>>>> .merge_file_ObWlTX
import { LoginService } from './services/login.service';
import { CommonModule } from '@angular/common';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSidenav, MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
<<<<<<< .merge_file_pK0wHD
  imports: [RouterOutlet, UsuarioComponent, PromocionComponent, PaisComponent,
    CiudadComponent, ComentarioComponent, DepartamentoComponent, FavoritoComponent, FestividadComponent,
    LugarturisticoComponent, MenbresiavipComponent, NegocioComponent, MatToolbarModule, RouterLink,
    RolComponent, MatMenuModule, MatIconModule, MatButtonModule, CommonModule],
=======
  imports: [RouterOutlet, RouterLink, MatToolbarModule, MatMenuModule, MatIconModule, MatButtonModule,
    CommonModule, MatListModule, MatSidenavModule, MatExpansionModule],
>>>>>>> .merge_file_ObWlTX
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'Turismap';
  role: string = '';
  loggedIn: boolean = false;

  @ViewChild('sidenav') sidenav!: MatSidenav;

  constructor(private loginService: LoginService, private router: Router) {}
  ngOnInit() {
    this.loggedIn = this.loginService.verificar();
    if (this.loggedIn) {
      this.role = this.loginService.showRole();
    }
    this.loginService.loggedIn$.subscribe((status) => {
      this.loggedIn = status;
      if (status) {
        this.role = this.loginService.showRole();
      } else {
        this.role = '';
      }
    });
  }

  cerrar() {
    // sessionStorage.clear();
    this.loginService.logout();
    this.router.navigate(['/login']);
  }

  verificar() {
    this.role = this.loginService.showRole();
    return this.loginService.verificar();
  }
  isAdmin() {
    return this.role === 'ADMIN';
  }
}
