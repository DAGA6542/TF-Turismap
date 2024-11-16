import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { MenbresiaVIP } from '../../../models/menbresiavip';
import { MenbresiavipService } from '../../../services/menbresiavip.service';

@Component({
  selector: 'app-listar-menbresiavip',
  standalone: true,
  imports: [MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule],
  templateUrl: './listar-menbresiavip.component.html',
  styleUrl: './listar-menbresiavip.component.css'
})
export class ListarMenbresiavipComponent {
  displayedColumns: string[] = ['idMenbresiaVIP', 'tipoMenbresiaVIP', 'fechaInicioMenbresiaVIP', 
    'fechaFinMenbresiaVIP', 'estadoMenbresiaVIP', 'beneficioMenbresiaVIP', 'idUsuario', 'accion1', 'accion2'];

  datasource: MatTableDataSource<MenbresiaVIP> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private mS: MenbresiavipService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.mS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
    this.mS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
    });
  }
  openDialog(id: number): void {}
  delete(id: number) {
    this.mS.delete(id).subscribe((data) => {
      this.mS.list().subscribe((data) => {
        this.mS.setList(data);
      });
    });
  }
}
