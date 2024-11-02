import { LugarTuristico } from "./lugarturistico";
import { Usuario } from "./usuario";
export class Comentario {
    idComentario: number = 0;
    textoComentario: string = "";
    fechaComentario: Date = new Date(Date.now());
    idUsuario: Usuario = new Usuario();
    idLugarTuristico: LugarTuristico = new LugarTuristico();
    idNegocio: number = 0;
}