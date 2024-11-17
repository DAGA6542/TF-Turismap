import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Ciudad } from '../../../models/ciudad';
import { CiudadService } from '../../../services/ciudad.service';
@Component({
  selector: 'app-listar-ciudad',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-ciudad.component.html',
  styleUrl: './listar-ciudad.component.css'
})
export class ListarCiudadComponent {
  displayedColumns: string[] = [
    'idCiudad',
    'nombreCiudad',
    'poblacionCiudad',
    'superficieCiudad',
    'codigoPostalCiudad',
    'idDepartamento',
    'idDepartamento1',
    'accion1',
    'accion2'];

  datasource: MatTableDataSource<Ciudad> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private cS: CiudadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.cS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
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