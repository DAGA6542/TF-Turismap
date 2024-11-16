import { Component, ViewChild, AfterViewInit, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { LugarTuristicoPorCiudadDTO } from '../../../models/LugarTuristicoPorCiudadDTO';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { MatSortModule } from '@angular/material/sort';
import { MatSort } from '@angular/material/sort';
@Component({
  selector: 'app-listar-lugar-turistico-por-ciudad',
  standalone: true,
  imports: [
    MatPaginatorModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    MatSortModule,
  ],
  templateUrl: './listar-lugar-turistico-por-ciudad.component.html',
  styleUrls: ['./listar-lugar-turistico-por-ciudad.component.css'] 
})
export class ListarLugarTuristicoPorCiudadComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['nombreCiudad', 'nombreLugar']; 

  datasource: MatTableDataSource<LugarTuristicoPorCiudadDTO> = new MatTableDataSource<LugarTuristicoPorCiudadDTO>();
  nombreCiudad: string = '';

  @ViewChild(MatPaginator) paginator!: MatPaginator;
@ViewChild(MatSort) sort!: MatSort;

  constructor(
    private ltS: LugarturisticoService
  ) {}

  ngOnInit(): void {
    this.datasource = new MatTableDataSource<LugarTuristicoPorCiudadDTO>([]);
    this.datasource.paginator = this.paginator;
  }
  ngAfterViewInit(): void {
    this.datasource.paginator = this.paginator;
    this.datasource.sort = this.sort;
  }
  searchByCiudad(): void {
    if (this.nombreCiudad.trim() !== '') {
      this.ltS.getLugarTuristicoXCiudad(this.nombreCiudad).subscribe((data) => {
        this.datasource.data = data;
      });
    } else {
      this.datasource.data = [];
    }
  }
}