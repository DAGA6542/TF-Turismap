import { LugarTuristico } from './../../../models/lugarturistico';
import { Component,  inject,  ViewChild } from '@angular/core';
import { toSignal} from '@angular/core/rxjs-interop';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink, Params } from '@angular/router';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import {GoogleMap, MapAdvancedMarker} from '@angular/google-maps';


@Component({
  selector: 'app-listar-lugarturistico',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule,GoogleMap,MapAdvancedMarker],
  templateUrl: './listar-lugarturistico.component.html',
  styleUrl: './listar-lugarturistico.component.css',
 
})
export class ListarLugarturisticoComponent {

  readonly #lugarTuristicoService= inject(LugarturisticoService)

LugarTuristico$=(this.#lugarTuristicoService.getCoordenadas({latitud:0,longitud:0}));
  $lugarturistico =toSignal(this.LugarTuristico$,{initialValue:[]});

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
  }
  openDialog(id: number): void {}
  delete(id: number) {
    this.ltS.delete(id).subscribe((data) => {
      this.ltS.list().subscribe((data) => {
        this.ltS.setList(data);
      });
    });
    
  }
}