import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { LugarTuristico } from '../../../models/lugarturistico';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input'; 
import { MatFormFieldModule } from '@angular/material/form-field'; 
import { FormsModule } from '@angular/forms'; 
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MatSort } from '@angular/material/sort';
import { MatSortModule } from '@angular/material/sort';
@Component({
  selector: 'app-listar-numero-de-lugar-turistico',
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
  templateUrl: './listar-numero-de-lugar-turistico.component.html',
  styleUrls: ['./listar-numero-de-lugar-turistico.component.css']
})
export class ListarNumeroDeLugarTuristicoComponent implements OnInit, AfterViewInit  {
  displayedColumns: string[] = ['nombreLugar', 'numeroTelefonoLugar'];

  datasource: MatTableDataSource<LugarTuristico> = new MatTableDataSource<LugarTuristico>();
  nombreLugar: string = '';

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private ltS: LugarturisticoService,
  ) { }

  ngOnInit(): void {
    this.datasource = new MatTableDataSource<LugarTuristico>([]);
    this.datasource.paginator = this.paginator;
  }

  searchByNombre(): void {
    if (this.nombreLugar.trim() !== '') {
      this.ltS.getNumeroxLugarTuristicoPorNombre(this.nombreLugar).subscribe((data) => {
        this.datasource = new MatTableDataSource<LugarTuristico>(data);
        this.datasource.paginator = this.paginator;
      });
    } else {
      this.datasource = new MatTableDataSource<LugarTuristico>([]); 
    }
  }
  ngAfterViewInit(): void {
    this.datasource.paginator = this.paginator;
    this.datasource.sort = this.sort;
  }
}