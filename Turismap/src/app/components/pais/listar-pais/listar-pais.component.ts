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
    MatIconModule, RouterLink,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-pais.component.html',
  styleUrl: './listar-pais.component.css'
})
export class ListarPaisComponent {
  displayedColumns: string[] = ['idPais', 'nombre', 'codigoIso', 'continente', 
    'capital', 'moneda', 'idiomaOficial', 'poblacion', 'superficie'];

  datasource: MatTableDataSource<Pais> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private tmS: PaisService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.tmS.list().subscribe((data) => {
      this.datasource.data = data;
      this.datasource.paginator = this.paginator;
    });
    this.tmS.getList().subscribe((data) => {
      this.datasource.data = data;
      this.datasource.paginator = this.paginator;
    });
  }
  openDialog(id: number): void {}
}
