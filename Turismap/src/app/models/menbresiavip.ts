import { LugarTuristico } from "./lugarturistico";
export class MenbresiaVIP {
    idFestividad: number = 0;
    nombreFestividad: string = "";
    descripcionFestividad: string = "";
    fechaFestividad: Date = new Date(Date.now());
    idLugarTuristico: LugarTuristico = new LugarTuristico();
}