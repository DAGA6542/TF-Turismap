import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatDialog, MatDialogModule, } from '@angular/material/dialog';
import { Usuario } from '../../../models/usuario';
import { UsuarioService } from '../../../services/usuario.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-listar-usuario',
  standalone: true,
  imports: [
    MatPaginatorModule, MatPaginator, MatTableModule,
    MatIconModule, RouterLink, MatTableModule,
    MatButtonModule, MatDialogModule, NgIf],
  templateUrl: './listar-usuario.component.html',
  styleUrl: './listar-usuario.component.css'
})
export class ListarUsuarioComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = [ 'idUsuario', 'username', 'nombreUsuario', 'emailUsuario',
    'contraseniaUsuario', 'telefonoUsuario', 'enabled', 'accion1', 'accion2'];
  datasource: MatTableDataSource<Usuario> = new MatTableDataSource();

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private uS: UsuarioService, private dialog: MatDialog) {}

  openDialog(id: number): void {}
  delete(id: number) {
    this.uS.delete(id).subscribe((data) => {
      this.uS.list().subscribe((data) => {
        this.uS.setList(data);
      });
    });
  }

  // Para mostrar poco de contraseña
  truncarContra(password: string): string {
    return password.length > 8 ? password.substring(0, 8) + '...' : password;
  }
  ngOnInit(): void {
    this.uS.list().subscribe((data) => {
      this.datasource= new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });

    this.uS.getList().subscribe((data) => {
      this.datasource= new MatTableDataSource(data);
      this.datasource.paginator = this.paginator;
    });
  }

  ngAfterViewInit(): void {
    this.datasource.paginator = this.paginator;
  }

}
