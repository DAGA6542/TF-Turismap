import { CommonModule } from '@angular/common';
import { Component, CUSTOM_ELEMENTS_SCHEMA, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink, Params } from '@angular/router';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { LugarTuristico } from '../../../models/lugarturistico';
import { GoogleMap, MapAdvancedMarker } from '@angular/google-maps';
import { LugarTuristicoDTO } from '../../../models/lugarturisticoDTO';

@Component({
  selector: 'app-listar-lugarturistico',
  standalone: true,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [CommonModule,
    MatTableModule,
    MatButtonModule, MatDialogModule, CommonModule,
    MatIconModule, RouterLink,GoogleMap,MapAdvancedMarker
  ],
  templateUrl: './listar-lugarturistico.component.html',
  styleUrl: './listar-lugarturistico.component.css',
 
})
export class ListarLugarturisticoComponent implements OnInit {
  coordenadas:LugarTuristicoDTO[]=[];
  center: google.maps.LatLngLiteral = {lat: -12.0873795, lng: -77.0500079};
  zoom = 18;
  markerPositions: google.maps.LatLngLiteral[] = [];
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
    });
    this.ltS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
    this.cargarCoordenadas();
  }
    delete (id: number): void {
      this.ltS.delete(id).subscribe(() => {
        alert('Lugar Turístico eliminado');
        this.ngOnInit();
      });
    }

  cargarCoordenadas() {
    this.ltS.obtenerCoordenadas().subscribe(
      (data) => {
        this.coordenadas = data;
  

        this.markerPositions = this.coordenadas.map(coord => ({
          lat: coord.latitudLugar,
          lng: coord.longitudLugar
        }));
  
        console.log('Coordenadas cargadas:', this.markerPositions);
      },
      (error) => {
        console.error('Error al obtener coordenadas:', error);
      }
    );
  }
  }

