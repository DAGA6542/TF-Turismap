
import { LugarTuristico } from './../../../models/lugarturistico';
import { Component,  CUSTOM_ELEMENTS_SCHEMA,  inject,  OnInit,  ViewChild } from '@angular/core';
import { toSignal} from '@angular/core/rxjs-interop';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink, Params } from '@angular/router';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import {GoogleMap, MapAdvancedMarker} from '@angular/google-maps';
import { LugarTuristicoDTO } from '../../../models/lugarturisticoDTO';
import { CommonModule } from '@angular/common';




@Component({
  selector: 'app-listar-lugarturistico',
  standalone: true,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [CommonModule,MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule,GoogleMap,MapAdvancedMarker],
  templateUrl: './listar-lugarturistico.component.html',
  styleUrl: './listar-lugarturistico.component.css',
 
})
export class ListarLugarturisticoComponent implements OnInit{
   coordenadas:LugarTuristicoDTO[]=[];
  center: google.maps.LatLngLiteral = {lat: -12.0873795, lng: -77.0500079};
  zoom = 18;
  markerPositions: google.maps.LatLngLiteral[] = [];


  displayedColumns: string[] = ['idLugarTuristico', 'nombre', 'descripcion',
 'numeroTelefono','idCiudad','accion1', 'accion2'];
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
  openDialog(id: number): void {}
  delete(id: number) {
    this.ltS.delete(id).subscribe((data) => {
      this.ltS.list().subscribe((data) => {
        this.ltS.setList(data);
      });
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