import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink, Params } from '@angular/router';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { LugarTuristico } from '../../../models/lugarturistico';

@Component({
  selector: 'app-listar-lugarturistico',
  standalone: true,
  imports: [
    MatTableModule,
    MatButtonModule, MatDialogModule, CommonModule,
    MatIconModule, RouterLink,
  ],
  templateUrl: './listar-lugarturistico.component.html',
  styleUrl: './listar-lugarturistico.component.css',
 
})
export class ListarLugarturisticoComponent implements OnInit {

  displayedColumns: string[] = [
    'idLugar',
    'nombreLugar',
    'descripcionLugar',
    'numeroTelefonoLugar',
    'nombreCiudad',
    'accion1',
    'accion2'
  ];
  
  datasource: MatTableDataSource<LugarTuristico> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private ltS: LugarturisticoService, private dialog: MatDialog) {}


  
  ngOnInit(): void {
    this.ltS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
    this.ltS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);

    });
  }
    delete (id: number): void {
      this.ltS.delete(id).subscribe(() => {
        alert('Lugar Turístico eliminado');
        this.ngOnInit();
      });
    }
  }

