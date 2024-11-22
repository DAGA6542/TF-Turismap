import { Usuario } from "./usuario";
export class MenbresiaVIP {
    idMenbresiaVIP: number = 0;
    tipoMenbresiaVIP: string = "";
    fechaInicioMenbresiaVIP: Date = new Date(Date.now());
    fechaFinMenbresiaVIP: Date = new Date(Date.now());
    estadoMenbresiaVIP: Boolean = true;
    beneficioMenbresiaVIP: string = "";
    idUsuario: Usuario = new Usuario();
}