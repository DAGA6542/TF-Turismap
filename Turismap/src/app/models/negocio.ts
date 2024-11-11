import { Ciudad } from "./ciudad";
import { Promocion } from "./promocion";
export class Negocio {
    idNegocio: number = 0;
    nombreNegocio: string = "";
    horarioNegocio: string = "";
    numeroTelefonoNegocio: number = 0;
    calificacionNegocio: number = 0;
    descripcionNegocio: string = ""; 
    reservaNegocio: boolean = true;
    idCiudad: Ciudad = new Ciudad();
    idPromocion: Promocion = new Promocion();
}