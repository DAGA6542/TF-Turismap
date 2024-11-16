import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Favorito } from '../../../models/favorito';
import { FavoritoService } from '../../../services/favorito.service';

@Component({
  selector: 'app-listar-favorito',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-favorito.component.html',
  styleUrl: './listar-favorito.component.css'
})
export class ListarFavoritoComponent {
  displayedColumns: string[] = ['idFavorito', 'fechaAgregadoFavorito', 'fechaModificacionFavorito', 
    'idUsuario', 'idLugar', 'idNegocio', 'accion1', 'accion2'];

  datasource: MatTableDataSource<Favorito> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private fS: FavoritoService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.fS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
    this.fS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void {}
  delete(id: number) {
    this.fS.delete(id).subscribe((data) => {
      this.fS.list().subscribe((data) => {
        this.fS.setList(data);
      });
    });
  }
}