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
export const routes: Routes = [
    {
        path: 'ciudad', component: CiudadComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'comentario', component: ComentarioComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'departamento', component: DepartamentoComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'favorito', component: FavoritoComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'festividad', component: FestividadComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'lugarturistico', component: LugarturisticoComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'menbresiavip', component: MenbresiavipComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'negocio', component: NegocioComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
    },
    {
        path: 'pais', component: PaisComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],
        
    },
    {
        path: 'promocion', component: PromocionComponent,
        children: [
            { path: 'insertar', component: InsertarPromocionComponent },
            { path: 'listar', component: ListarPromocionComponent },
            { path: 'editar/:id', component: InsertarPromocionComponent }
        ],
    },
    {
        path: 'usuario', component: UsuarioComponent,
        children: [
            { path: 'insertar', component: InsertarUsuarioComponent },
            { path: 'listar', component: ListarUsuarioComponent },
            { path: 'editar/:id', component: InsertarUsuarioComponent }
        ],
    },
    {
        path: 'rol', component: RolComponent,
        children: [
            { path: 'insertar', component: InsertarPaisComponent },
            { path: 'listar', component: ListarPaisComponent },
            { path: 'editar/:id', component: InsertarPaisComponent }
        ],  
    },
];
