import { Routes } from '@angular/router';
import { PaisComponent } from './components/pais/pais.component';
import { PromocionComponent } from './components/promocion/promocion.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { InsertarPromocionComponent } from './components/promocion/insertar-promocion/insertar-promocion.component';
import { ListarPromocionComponent } from './components/promocion/listar-promocion/listar-promocion.component';
import { InsertarUsuarioComponent } from './components/usuario/insertar-usuario/insertar-usuario.component';
import { ListarUsuarioComponent } from './components/usuario/listar-usuario/listar-usuario.component';
import { InsertarPaisComponent } from './components/pais/insertar-pais/insertar-pais.component';
import { ListarPaisComponent } from './components/pais/listar-pais/listar-pais.component';
import { CiudadComponent } from './components/ciudad/ciudad.component';
import { ComentarioComponent } from './components/comentario/comentario.component';
import { DepartamentoComponent } from './components/departamento/departamento.component';
import { FavoritoComponent } from './components/favorito/favorito.component';
import { FestividadComponent } from './components/festividad/festividad.component';
import { LugarturisticoComponent } from './components/lugarturistico/lugarturistico.component';
import { MenbresiavipComponent } from './components/menbresiavip/menbresiavip.component';
import { NegocioComponent } from './components/negocio/negocio.component';
import { RolComponent } from './components/rol/rol.component';
import { InsertarCiudadComponent } from './components/ciudad/insertar-ciudad/insertar-ciudad.component';
import { ListarCiudadComponent } from './components/ciudad/listar-ciudad/listar-ciudad.component';
import { InsertarComentarioComponent } from './components/comentario/insertar-comentario/insertar-comentario.component';
import { ListarComentarioComponent } from './components/comentario/listar-comentario/listar-comentario.component';
import { InsertarDepartamentoComponent } from './components/departamento/insertar-departamento/insertar-departamento.component';
import { ListarDepartamentoComponent } from './components/departamento/listar-departamento/listar-departamento.component';
import { InsertarFavoritoComponent } from './components/favorito/insertar-favorito/insertar-favorito.component';
import { ListarFavoritoComponent } from './components/favorito/listar-favorito/listar-favorito.component';
import { InsertarFestividadComponent } from './components/festividad/insertar-festividad/insertar-festividad.component';
import { ListarFestividadComponent } from './components/festividad/listar-festividad/listar-festividad.component';
import { InsertarLugarturisticoComponent } from './components/lugarturistico/insertar-lugarturistico/insertar-lugarturistico.component';
import { ListarLugarturisticoComponent } from './components/lugarturistico/listar-lugarturistico/listar-lugarturistico.component';
import { InsertarMenbresiavipComponent } from './components/menbresiavip/insertar-menbresiavip/insertar-menbresiavip.component';
import { ListarMenbresiavipComponent } from './components/menbresiavip/listar-menbresiavip/listar-menbresiavip.component';
import { InsertarNegocioComponent } from './components/negocio/insertar-negocio/insertar-negocio.component';
import { ListarNegocioComponent } from './components/negocio/listar-negocio/listar-negocio.component';
import { InsertarRolComponent } from './components/rol/insertar-rol/insertar-rol.component';
import { ListarRolComponent } from './components/rol/listar-rol/listar-rol.component';
import { LoginComponent } from './components/login/login.component';
import { seguridadGuard } from './guard/seguridad.guard';
import { HomeComponent } from './components/home/home.component';
import { ReportesComponent } from './components/reportes/reportes.component';
import { ListarLugarTuristicoPorCiudadComponent } from './components/reportes/listar-lugar-turistico-por-ciudad/listar-lugar-turistico-por-ciudad.component';
import { ListarNumeroDeLugarTuristicoComponent } from './components/reportes/listar-numero-de-lugar-turistico/listar-numero-de-lugar-turistico.component';
import { CalcularCantidadCiudadxturismoComponent } from './components/reportes/calcular-cantidad-ciudadxturismo/calcular-cantidad-ciudadxturismo.component';
import { CantidadRolesComponent } from './components/reportes/cantidad-roles/cantidad-roles.component';
import { BuscarUsuarioConMasComentariosEnNegocioComponent } from './components/reportes/buscar-usuario-con-mas-comentarios-en-negocio/buscar-usuario-con-mas-comentarios-en-negocio.component';
import { CalcularTurismoPorCiudadComponent } from './components/reportes/calcular-turismo-por-ciudad/calcular-turismo-por-ciudad.component';
import { ContarPorLugarTuristicoComponent } from './components/reportes/contar-por-lugar-turistico/contar-por-lugar-turistico.component';
import { ListarUsuariosConMasComentariosComponent } from './components/reportes/listar-usuarios-con-mas-comentarios/listar-usuarios-con-mas-comentarios.component';
import { PromocionesActivaConNegocioParticipantesComponent } from './components/reportes/promociones-activa-con-negocio-participantes/promociones-activa-con-negocio-participantes.component';
import { UsuariosConMasMembresiasActivasComponent } from './components/reportes/usuarios-con-mas-membresias-activas/usuarios-con-mas-membresias-activas.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full',
    },
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'ciudad', component: CiudadComponent,
        children: [
            { path: 'insertar', component: InsertarCiudadComponent },
            { path: 'listar', component: ListarCiudadComponent },
            { path: 'editar/:id', component: InsertarCiudadComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'comentario', component: ComentarioComponent,
        children: [
            { path: 'insertar', component: InsertarComentarioComponent },
            { path: 'listar', component: ListarComentarioComponent },
            { path: 'editar/:id', component: InsertarComentarioComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'departamento', component: DepartamentoComponent,
        children: [
            { path: 'insertar', component: InsertarDepartamentoComponent },
            { path: 'listar', component: ListarDepartamentoComponent },
            { path: 'editar/:id', component: InsertarDepartamentoComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'favorito', component: FavoritoComponent,
        children: [
            { path: 'insertar', component: InsertarFavoritoComponent },
            { path: 'listar', component: ListarFavoritoComponent },
            { path: 'editar/:id', component: InsertarFavoritoComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'festividad', component: FestividadComponent,
        children: [
            { path: 'insertar', component: InsertarFestividadComponent },
            { path: 'listar', component: ListarFestividadComponent },
            { path: 'editar/:id', component: InsertarFestividadComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'lugarturistico', component: LugarturisticoComponent,
        children: [
            { path: 'insertar', component: InsertarLugarturisticoComponent },
            { path: 'listar', component: ListarLugarturisticoComponent },
            { path: 'editar/:id', component: InsertarLugarturisticoComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'menbresiavip', component: MenbresiavipComponent,
        children: [
            { path: 'insertar', component: InsertarMenbresiavipComponent },
            { path: 'listar', component: ListarMenbresiavipComponent },
            { path: 'editar/:id', component: InsertarMenbresiavipComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'negocio', component: NegocioComponent,
        children: [
            { path: 'insertar', component: InsertarNegocioComponent },
            { path: 'listar', component: ListarNegocioComponent },
            { path: 'editar/:id', component: InsertarNegocioComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'pais', component: PaisComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'promocion', component: PromocionComponent,
        children: [
            { path: 'insertar', component: InsertarPromocionComponent },
            { path: 'listar', component: ListarPromocionComponent },
            { path: 'editar/:id', component: InsertarPromocionComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'usuario', component: UsuarioComponent,
        children: [
            { path: 'insertar', component: InsertarUsuarioComponent },
            { path: 'listar', component: ListarUsuarioComponent },
            { path: 'editar/:id', component: InsertarUsuarioComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'rol', component: RolComponent,
        children: [
            { path: 'insertar', component: InsertarRolComponent },
            { path: 'listar', component: ListarRolComponent },
            { path: 'editar/:id', component: InsertarRolComponent }
        ],
        canActivate: [seguridadGuard],
    },
    {
        path: 'reportes',
        component: ReportesComponent,
        children: [
          {
            path: 'listadolugarturisticoporciudad',
            component: ListarLugarTuristicoPorCiudadComponent,
          },
          {
            path: 'listadonumerolugarturistico',
            component: ListarNumeroDeLugarTuristicoComponent,
          },
          {
            path: 'CalcularCantidadCiudadxturismoComponent',
            component: CalcularCantidadCiudadxturismoComponent,
          },
          {
            path: 'CantidadRolesComponent',
            component: CantidadRolesComponent,
          },
          {
            path: 'BuscarUsuarioConMasComentariosEnNegocioComponent',
            component: BuscarUsuarioConMasComentariosEnNegocioComponent,
          },
          {
            path: 'CalcularTurismoPorCiudadComponent',
            component: CalcularTurismoPorCiudadComponent,
          },
          {
            path: 'ContarPorLugarTuristicoComponent',
            component: ContarPorLugarTuristicoComponent,
          },
          {
            path: 'ListarUsuariosConMasComentariosComponent',
            component: ListarUsuariosConMasComentariosComponent,
          },
          {
            path: 'PromocionesActivaConNegocioParticipantesComponent',
            component: PromocionesActivaConNegocioParticipantesComponent,
          },
          {
            path: 'UsuariosConMasMembresiasActivasComponent',
            component: UsuariosConMasMembresiasActivasComponent,
          },

        ],
      },
    {
        path: 'homes',
        component: HomeComponent,
        canActivate: [seguridadGuard],
    },
];
