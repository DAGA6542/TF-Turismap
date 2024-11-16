import { CommonModule, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Departamento } from '../../../models/departamento';
import { DepartamentoService } from '../../../services/departamento.service';
import { Pais } from '../../../models/pais';
import { PaisService } from '../../../services/pais.service';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';

@Component({
  selector: 'app-insertar-departamento',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatDatepickerModule],
  templateUrl: './insertar-departamento.component.html',
  styleUrl: './insertar-departamento.component.css'
})
export class InsertarDepartamentoComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  listaPaises: Pais[] = [];
  departamento: Departamento = new Departamento()
  edicion: boolean = false;
  id: number = 0;
  //
  constructor(
    private formbuilder: FormBuilder,
    private pS: PaisService,
    private Dep: DepartamentoService,
    private router: Router,
  ) { }
  ngOnInit(): void {
    this.form = this.formbuilder.group({
      hnombreDepartamento: ['', Validators.required],
      hcapitalDepartamento: ['', Validators.required],
      hpoblacionDepartamento: ['', Validators.required],
      hsuperficieDepartamento: ['', Validators.required],
      hPais: ['', Validators.required],
    });
    this.pS.list().subscribe((data) => {
      this.listaPaises = data;
    });
  }
  insertar(): void {
    if (this.form.valid) {
      this.departamento.nombreDepartamento = this.form.value.hnombreDepartamento;
      this.departamento.capitalDepartamento = this.form.value.hcapitalDepartamento;
      this.departamento.poblacionDepartamento = this.form.value.hpoblacionDepartamento;
      this.departamento.superficieDepartamento = this.form.value.hsuperficieDepartamento;
      this.departamento.idPais.idPais = this.form.value.hPais;
      
      if(this.edicion){
      this.Dep.update(this.departamento).subscribe((data) => {
        this.Dep.list().subscribe((data) => {
          this.Dep.setList(data);
        });
      });
    } else{
      this.Dep.insert(this.departamento).subscribe((data) => {
        this.Dep.list().subscribe((data) => {
          this.Dep.setList(data);
        });
      });
    }
      this.router.navigate(['departamento']);
    }
  }
}