import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Promocion } from '../../../models/promocion';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { PromocionService } from '../../../services/promocion.service';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-listar-promocion',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-promocion.component.html',
  styleUrl: './listar-promocion.component.css'
})
export class ListarPromocionComponent implements OnInit{
  displayedColumns: string[] = [    
    'idPromocion','nombrePromocion','descripcionPromocion','precioPromocion',
    'descuentoPromocion','fechaInicioPromocion','fechaFinPromocion'];

    datasource: MatTableDataSource<Promocion> = new MatTableDataSource();

    @ViewChild(MatPaginator) paginator! : MatPaginator;

    constructor(private promS: PromocionService, private dialog:MatDialog){}

    ngOnInit(): void{
      this.promS.list().subscribe((data)=>{
        this.datasource = new MatTableDataSource(data);
      });
      this.promS.getList().subscribe((data)=>{
        this.datasource = new MatTableDataSource(data);
      });
    }
    openDialog(id: number): void{}
    delete(id: number){
      this.promS.delete(id).subscribe((data)=>{
        this.promS.list().subscribe((data)=>{
          this.promS.setList(data);
        });
      });
    }
}