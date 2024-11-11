import { LugarTuristico } from "./lugarturistico";
export class Festividad {
    idFestividades: number = 0;
    nombreFestividad: string = "";
    descripcionFestividad: string = "";
    fechaFestividad: Date = new Date(Date.now());
    idLugar: LugarTuristico = new LugarTuristico();
}