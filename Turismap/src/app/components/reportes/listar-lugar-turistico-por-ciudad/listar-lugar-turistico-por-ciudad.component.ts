import { Component, ViewChild, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { LugarTuristicoPorCiudadDTO } from '../../../models/LugarTuristicoPorCiudadDTO';
import { LugarturisticoService } from '../../../services/lugarturistico.service';

@Component({
  selector: 'app-listar-lugar-turistico-por-ciudad',
  standalone: true,
  imports: [
    MatPaginator,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './listar-lugar-turistico-por-ciudad.component.html',
  styleUrls: ['./listar-lugar-turistico-por-ciudad.component.css'] 
})
export class ListarLugarTuristicoPorCiudadComponent implements OnInit {
  displayedColumns: string[] = ['nombreCiudad', 'nombreLugar']; 

  datasource: MatTableDataSource<LugarTuristicoPorCiudadDTO> = new MatTableDataSource<LugarTuristicoPorCiudadDTO>();
  nombreCiudad: string = '';

  @ViewChild(MatPaginator) paginator!: MatPaginator; 

  constructor(
    private ltS: LugarturisticoService
  ) {}

  ngOnInit(): void {
    this.datasource = new MatTableDataSource<LugarTuristicoPorCiudadDTO>([]);
    this.datasource.paginator = this.paginator;
  }

  searchByCiudad(): void {
    if (this.nombreCiudad.trim() !== '') {
      this.ltS.getLugarTuristicoXCiudad(this.nombreCiudad).subscribe((data) => {
        this.datasource = new MatTableDataSource<LugarTuristicoPorCiudadDTO>(data);
        this.datasource.paginator = this.paginator;
      });
    } else {
      this.datasource = new MatTableDataSource<LugarTuristicoPorCiudadDTO>([]);
    }
  }
}
