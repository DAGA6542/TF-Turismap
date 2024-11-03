export class Promocion {
    idPromocion: number = 0;
    nombrePromocion: String = "";
    descripcionPromocion: String = "";
    precioPromocion: number = 0;
    descuentoPromocion: number = 0;
    fechaInicioPromocion: Date = new Date(Date.now());
    fechaFinPromocion: Date = new Date(Date.now());
}