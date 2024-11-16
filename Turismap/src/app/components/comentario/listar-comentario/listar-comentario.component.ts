import { Component, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { Comentario } from '../../../models/comentario';
import { ComentarioService } from '../../../services/comentario.service';

@Component({
  selector: 'app-listar-comentario',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-comentario.component.html',
  styleUrl: './listar-comentario.component.css'
})
export class ListarComentarioComponent {
  displayedColumns: string[] = [
    'idComentario',
    'textoComentario',
    'fechaComentario',
    'idUsuario',
    'NombreLugarTuristico',
    'codigoNegocio',
    'nombreNegocio',
    'accion1',
    'accion2'];
datasource:MatTableDataSource<Comentario> = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private cS:ComentarioService, private dialog:MatDialog){}

  ngOnInit(): void {
    this.cS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator=this.paginator;
    });
    this.cS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void { }
  delete(id: number) {
    this.cS.delete(id).subscribe((data) => {
      this.cS.list().subscribe((data) => {
        this.cS.setList(data);
      });
    });
  }
}