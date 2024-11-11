import { LugarTuristico } from "./lugarturistico";
import { Negocio } from "./negocio";
import { Usuario } from "./usuario";
export class Favorito {
    idFavorito: number = 0;
    fechaAgregadoFavorito: Date = new Date(Date.now());
    fechaModificacionFavorito: Date = new Date(Date.now());
    idUsuario: Usuario = new Usuario();
    idLugar: LugarTuristico = new LugarTuristico();
    idNegocio: Negocio = new Negocio;
}