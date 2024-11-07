import { CommonModule, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Departamento } from '../../../models/departamento';
import { DepartamentoService } from '../../../services/departamento.service';

@Component({
  selector: 'app-insertar-departamento',
  standalone: true,
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule],
  templateUrl: './insertar-departamento.component.html',
  styleUrl: './insertar-departamento.component.css'
})
export class InsertarDepartamentoComponent {
  form: FormGroup = new FormGroup({});
  departamento: Departamento = new Departamento()
  edicion: boolean = false;
  id: number = 0;
  //
  constructor(
    private Dep: DepartamentoService,
    private router: Router,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute
  ) { }
  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] > 0;
      this.init()
    });
    this.form = this.formbuilder.group({
      idDepartamento: [''],
      nombreDepartamento: ['', Validators.required],
      capitalDepartamento: ['', Validators.required],
      poblacionDepartamento: ['', Validators.required],
      superficieDepartamento: ['', Validators.required],
      idPais: ['', Validators.required],

    });
  }
  insertar(): void {
    if (this.form.valid) {
      this.departamento.idDepartamento = this.form.value.hidDepartamento;
      this.departamento.nombreDepartamento = this.form.value.hnombreDepartamento;
      this.departamento.capitalDepartamento = this.form.value.hcapitalDepartamento;
      this.departamento.poblacionDepartamento = this.form.value.hpoblacionDepartamento;
      this.departamento.superficieDepartamento = this.form.value.hsuperficieDepartamento;
      this.departamento.idPais = this.form.value.hidPais;

      if (this.edicion) {
        this.Dep.update(this.departamento).subscribe((data) => {
          this.Dep.list().subscribe((data) => {
            this.Dep.setList(data);
          });
        });
      } else {
        this.Dep.insert(this.departamento).subscribe((data) => {
          this.Dep.list().subscribe((data) => {
            this.Dep.setList(data);
          });
        });
      }
      this.router.navigate(['lugarturistico']);
    }
  }
  init() {
    if (this.edicion) {
      this.Dep.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidDepartamento: new FormControl(data.idDepartamento),
          hnombreDepartamento: new FormControl(data.nombreDepartamento),
          hcapitalDepartamento: new FormControl(data.capitalDepartamento),
          hpoblacionDepartamento: new FormControl(data.poblacionDepartamento),
          hsuperficieDepartamento: new FormControl(data.superficieDepartamento),
          hidPais: new FormControl(data.idPais),
          
        });
      });
    }
  }

}
