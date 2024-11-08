import { Component } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Departamento } from '../../../models/departamento';
import { DepartamentoService } from '../../../services/departamento.service';

@Component({
  selector: 'app-listar-departamento',
  standalone: true,
  imports: [MatTableModule],
  templateUrl: './listar-departamento.component.html',
  styleUrl: './listar-departamento.component.css'
})
export class ListarDepartamentoComponent {
  datasource: MatTableDataSource<Departamento> = new MatTableDataSource();
  displayedColumns: string[] = [
    'ctt1',
    'ctt2',
    'ctt3',
    'ctt4',
    'ctt5',
    'ctt6',
  ]
    constructor(private DepS: DepartamentoService) {}
    ngOnInit(): void {
      this.DepS.list().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
      this.DepS.getList().subscribe((data) => {
        this.datasource = new MatTableDataSource(data);
      });
    }
}
