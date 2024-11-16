import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Negocio } from '../../../models/negocio';
import { NegocioService } from '../../../services/negocio.service';

@Component({
  selector: 'app-listar-negocio',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-negocio.component.html',
  styleUrl: './listar-negocio.component.css'
})
export class ListarNegocioComponent {
  displayedColumns: string[] = ['idNegocio', 'nombreNegocio', 'horarioNegocio', 
    'numeroTelefonoNegocio', 'calificacionNegocio', 'descripcionNegocio', 'reservaNegocio',
    'idCiudad', 'idPromocion', 'accion1', 'accion2'];
  datasource: MatTableDataSource<Negocio> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  constructor(private nS: NegocioService, private dialog: MatDialog) { }
  
  ngOnInit(): void {
      this.nS.list().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
      this.nS.getList().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
    }
    openDialog(id: number): void { }
    delete(id: number) {
      this.nS.delete(id).subscribe((data) => {
        this.nS.list().subscribe((data) => {
          this.nS.setList(data);
        });
      });
    }
}