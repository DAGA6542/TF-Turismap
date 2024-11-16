import { Pais } from "./pais";
export class Departamento {
    idDepartamento: number = 0;
    nombreDepartamento: string = "";
    capitalDepartamento: string = "";
    poblacionDepartamento: number = 0;
    superficieDepartamento: number = 0;
    idPais: Pais = new Pais();
}