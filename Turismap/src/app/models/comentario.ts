import { LugarTuristico } from "./lugarturistico";
import { Negocio } from "./negocio";
import { Usuario } from "./usuario";
export class Comentario {
    idComentario: number = 0;
    textoComentario: string = "";
    fechaComentario: Date = new Date(Date.now());
    idUsuario: Usuario = new Usuario();
    idLugar: LugarTuristico = new LugarTuristico();
    idNegocio: Negocio = new Negocio();
}