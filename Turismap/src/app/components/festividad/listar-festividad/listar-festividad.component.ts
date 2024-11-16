import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Negocio } from '../../../models/negocio';
import { NegocioService } from '../../../services/negocio.service';
import { FestividadService } from '../../../services/festividad.service';
import { Festividad } from '../../../models/festividad';

@Component({
  selector: 'app-listar-festividad',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-festividad.component.html',
  styleUrl: './listar-festividad.component.css'
})
export class ListarFestividadComponent {
  displayedColumns: string[] = ['idFestividades', 'nombreFestividad', 'descripcionFestividad', 
    'fechaFestividad', 'idLugar', 'accion1', 'accion2'];
  datasource: MatTableDataSource<Festividad> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  
  constructor(private fS: FestividadService, private dialog: MatDialog) { }
  
  ngOnInit(): void {
      this.fS.list().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
      this.fS.getList().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
    }
    openDialog(id: number): void { }
    delete(id: number) {
      this.fS.delete(id).subscribe((data) => {
        this.fS.list().subscribe((data) => {
          this.fS.setList(data);
        });
      });
    }
}
