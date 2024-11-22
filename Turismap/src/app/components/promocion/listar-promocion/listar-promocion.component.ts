import { Component, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { Promocion } from '../../../models/promocion';
import { PromocionService } from '../../../services/promocion.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listar-promocion',
  standalone: true,
  imports: [
    MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule, CommonModule,
  ],
  templateUrl: './listar-promocion.component.html',
  styleUrl: './listar-promocion.component.css'
})
export class ListarPromocionComponent {
  displayedColumns: string[] = [
    'idPromocion',
    'nombrePromocion',
    'descripcionPromocion',
    'precioPromocion',
    'descuentoPromocion',
    'fechaInicioPromocion',
    'fechaFinPromocion',
    'accion1',
    'accion2'];

  datasource: MatTableDataSource<Promocion> = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private pS: PromocionService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.pS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
    this.pS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void { }
  delete(id: number) {
    this.pS.delete(id).subscribe((data) => {
      this.pS.list().subscribe((data) => {
        this.pS.setList(data);
      });
    });
  }
}
