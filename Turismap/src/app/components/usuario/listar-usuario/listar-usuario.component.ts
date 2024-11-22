import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Usuario } from '../../../models/usuario';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-listar-usuario',
  standalone: true,
  imports: [
    MatPaginatorModule, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule, MatPaginator],
  templateUrl: './listar-usuario.component.html',
  styleUrl: './listar-usuario.component.css'
})
export class ListarUsuarioComponent {
  displayedColumns: string[] = [ 'idUsuario', 'username', 'nombreUsuario', 'emailUsuario',
     'telefonoUsuario', 'enabled', 'accion1', 'accion2'];
  datasource: MatTableDataSource<Usuario> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private uS: UsuarioService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.uS.list().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
    this.uS.getList().subscribe((data) => {
      this.datasource = new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
  }
  openDialog(id: number): void {}
  delete(id: number) {
    this.uS.delete(id).subscribe((data) => {
      this.uS.list().subscribe((data) => {
        this.uS.setList(data);
      });
    });
  }
}
