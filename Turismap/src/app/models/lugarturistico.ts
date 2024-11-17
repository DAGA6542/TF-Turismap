import { Ciudad } from "./ciudad";
export class LugarTuristico {
    idLugar: number = 0;
    nombreLugar: string = "";
    latitudLugar: number = 0;
    longitudLugar: number = 0;
    descripcionLugar: string = "";
    numeroLugar: number = 0;
    idCiudad: Ciudad = new Ciudad();
}