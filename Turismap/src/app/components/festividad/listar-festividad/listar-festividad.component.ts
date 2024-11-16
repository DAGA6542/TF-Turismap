import { Component, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { Festividad } from '../../../models/festividad';
import { FestividadService } from '../../../services/festividad.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar-festividad',
  standalone: true,
  imports: [
    MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule,CommonModule,
  ],
  templateUrl: './listar-festividad.component.html',
  styleUrl: './listar-festividad.component.css'
})
export class ListarFestividadComponent {
  displayedColumns: string[] = [
    'idFestividad',
    'nombreFestividad',
    'descripcionFestividad',
    'fechaFestividad',
    'nombreLugarTuristico',
    'accion1',
    'accion2'];

  datasource: MatTableDataSource<Festividad> = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private fS: FestividadService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.fS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
    this.fS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void { }
  delete(id: number) {
    this.fS.delete(id).subscribe((data) => {
      this.fS.list().subscribe((data) => {
        this.fS.setList(data);
      });
    });
  }
}
