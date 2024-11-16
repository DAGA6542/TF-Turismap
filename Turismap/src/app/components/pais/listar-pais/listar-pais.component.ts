import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Pais } from '../../../models/pais';
import { PaisService } from '../../../services/pais.service';
@Component({
  selector: 'app-listar-pais',
  standalone: true,
  imports: [
    MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-pais.component.html',
  styleUrl: './listar-pais.component.css'
})
export class ListarPaisComponent {
  displayedColumns: string[] = ['idPais', 'nombre', 'codigoIso', 'continente', 
    'capital', 'moneda', 'idiomaOficial', 'poblacion', 'superficie', 'accion1', 'accion2'];

  datasource: MatTableDataSource<Pais> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private pS: PaisService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.pS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
    this.pS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void {}
  delete(id: number) {
    this.pS.delete(id).subscribe((data) => {
      this.pS.list().subscribe((data) => {
        this.pS.setList(data);
      });
    });
  }
}
