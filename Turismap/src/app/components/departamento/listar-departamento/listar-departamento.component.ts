import { Component, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Departamento } from '../../../models/departamento';
import { DepartamentoService } from '../../../services/departamento.service';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { RouterLink } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-listar-departamento',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-departamento.component.html',
  styleUrl: './listar-departamento.component.css'
})
export class ListarDepartamentoComponent {
  displayedColumns: string[] = [
    'ctt1',
    'ctt2',
    'ctt3',
    'ctt4',
    'ctt5',
    'ctt6',
    'accion1',
    'accion2'];

    datasource: MatTableDataSource<Departamento> = new MatTableDataSource();

    @ViewChild(MatPaginator) paginator!: MatPaginator;

    constructor(private DepS: DepartamentoService) {}

    ngOnInit(): void {
      this.DepS.list().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
      this.DepS.getList().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
    }
    openDialog(id:number):void{}
    delete(id:number){
      this.DepS.delete(id).subscribe((data)=>{
        this.DepS.list().subscribe((data)=>{
          this.DepS.setList(data);
        });
      });
    }
}