import { CommonModule } from '@angular/common';
import { Component, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { LugarTuristico } from '../../../models/lugarturistico';
import { LugarturisticoService } from '../../../services/lugarturistico.service';

@Component({
  selector: 'app-listar-lugarturistico',
  standalone: true,
  imports: [
    MatTableModule,
    MatButtonModule, MatDialogModule, CommonModule,
    MatIconModule, RouterLink,
  ],
  templateUrl: './listar-lugarturistico.component.html',
  styleUrl: './listar-lugarturistico.component.css'
})
export class ListarLugarturisticoComponent {
  datasource: MatTableDataSource<LugarTuristico> = new MatTableDataSource();
  displayedColumns: string[] = [
    'idLugarTuristico',
    'nombreLugarTuristico',
    'descripcionLugarTuristico',
    'numeroTelefonoLugar',
    'nombreCiudad',
    'accion1',
    'accion2'
  ];


  constructor(private ltS: LugarturisticoService) { }

  ngOnInit(): void {
    this.ltS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
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
  
