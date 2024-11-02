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

export const routes: Routes = [
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
            { path: 'listar', component: ListarPromocionComponent }
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
];
