import { Ciudad } from "./ciudad";
import { Promocion } from "./promocion";
export class Negocio {
    idNegocio: number = 0;
    nombreNegocio: string = "";
    latitudNegocio: number = 0;
    longitudNegocio: number = 0;
    horarioNegocio: string = "";
    numeroTelefonoNegocio: number = 0;
    calificacionNegocio: number = 0;
    descripcionNegocio: string = ""; 
    reservaNegocio: boolean = false;
    idCiudad: Ciudad = new Ciudad();
    idPromocion: Promocion = new Promocion();
}