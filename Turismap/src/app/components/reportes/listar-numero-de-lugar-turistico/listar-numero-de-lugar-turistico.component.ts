import { Component, OnInit, ViewChild } from '@angular/core';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { LugarTuristico } from '../../../models/lugarturistico';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';


@Component({
  selector: 'app-listar-numero-de-lugar-turistico',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-numero-de-lugar-turistico.component.html',
  styleUrl: './listar-numero-de-lugar-turistico.component.css'
})
export class ListarNumeroDeLugarTuristicoComponent implements OnInit {
  displayedColumns: string[] = ['nombre', 'numeroTelefono'];

  datasource: MatTableDataSource<LugarTuristico> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private ltS: LugarturisticoService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.ltS.getNumeroxLugarTuristico().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
    this.ltS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
}
