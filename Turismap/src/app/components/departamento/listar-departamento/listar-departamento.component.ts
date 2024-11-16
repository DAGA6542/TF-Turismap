import { Component, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { Departamento } from '../../../models/departamento';
import { DepartamentoService } from '../../../services/departamento.service';

@Component({
  selector: 'app-listar-departamento',
  standalone: true,
  imports: [
    MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule,
  ],
  templateUrl: './listar-departamento.component.html',
  styleUrl: './listar-departamento.component.css'
})
export class ListarDepartamentoComponent {
  displayedColumns: string[] = [
    'idDepartamento',
    'nombreDepartamento',
    'capitalDepartamento',
    'poblacionDepartamento',
    'superficieDepartamento',
    'idPais',
    'accion1',
    'accion2'];

  datasource: MatTableDataSource<Departamento> = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private dS: DepartamentoService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.dS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
    this.dS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void { }
  delete(id: number) {
    this.dS.delete(id).subscribe((data) => {
      this.dS.list().subscribe((data) => {
        this.dS.setList(data);
      });
    });
  }
}
