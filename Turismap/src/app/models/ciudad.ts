import { Departamento } from "./departamento";
export class Ciudad {
    idCiudad: number = 0;
    nombreCiudad: string = "";
    poblacionCiudad: number = 0;
    superficieCiudad: number = 0;
    latitudCiudad: number = 0;
    longitudCiudad: number = 0;
    codigoPostalCiudad: number = 0;
    idDepartamento: Departamento = new Departamento();
}