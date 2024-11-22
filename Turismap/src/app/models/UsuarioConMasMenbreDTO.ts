export class UsuarioConMasMenbreDTO {
    usuario: string = "";
    tipoMembresia: string = "";
    beneficios: string = "";
    inicio: Date = new Date(Date.now());
    fin: Date = new Date(Date.now());
}