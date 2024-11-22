import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Ciudad } from '../../../models/ciudad';
import { CiudadService } from '../../../services/ciudad.service';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';
import { Departamento } from '../../../models/departamento';
import { DepartamentoService } from '../../../services/departamento.service';

@Component({
  selector: 'app-insertar-ciudad',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatDatepickerModule],
  templateUrl: './insertar-ciudad.component.html',
  styleUrl: './insertar-ciudad.component.css'
})
export class InsertarCiudadComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  listarDepartamento: Departamento[] = [];
  ciudad: Ciudad = new Ciudad()
  edicion: boolean = false;
  id: number = 0;
  //

  constructor(
    private formbuilder: FormBuilder,
    private depS: DepartamentoService,
    private ciuS: CiudadService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] > 0;
      this.init()
    });
    this.form = this.formbuilder.group({
      hnombreCiudad: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$')]],// Solo letras y espacios
      hpoblacionCiudad: ['', [Validators.required, Validators.pattern('^[0-9]+$')]], // Solo números positivos (sin decimales)
      hsuperficieCiudad: ['', [Validators.required, Validators.pattern('^[0-9]+(\\.[0-9]+)?$')]],// Números positivos (puede tener decimales
      hcodigoPostalCiudad: ['', [Validators.required, Validators.pattern('^[0-9]{5}$')]], //Debe ser numérico y tener exactamente 5 dígitos
      hDepartamento: ['', Validators.required],
    });
    this.depS.list().subscribe((data) => {
      this.listarDepartamento = data;
    });
    // xd
  }
  insertar(): void {
    if (this.form.valid) {
      this.ciudad.nombreCiudad = this.form.value.hnombreCiudad;
      this.ciudad.poblacionCiudad = this.form.value.hpoblacionCiudad;
      this.ciudad.superficieCiudad = this.form.value.hsuperficieCiudad;
      this.ciudad.codigoPostalCiudad = this.form.value.hcodigoPostalCiudad;
      this.ciudad.idDepartamento.idDepartamento = this.form.value.hDepartamento;

      if (this.edicion) {
        this.ciuS.update(this.ciudad).subscribe((data) => {
          this.ciuS.list().subscribe((data) => {
            this.ciuS.setList(data);
          });
        });
      } else {
        this.ciuS.insert(this.ciudad).subscribe((data) => {
          this.ciuS.list().subscribe((data) => {
            this.ciuS.setList(data);
          });
        });
      }

      this.router.navigate(['ciudad']);
    }
  }
  init() {
    if (this.edicion) {
      this.ciuS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hnombreCiudad: new FormControl(data.nombreCiudad),
          hpoblacionCiudad: new FormControl(data.poblacionCiudad),
          hsuperficieCiudad: new FormControl(data.superficieCiudad),
          hcodigoPostalCiudad: new FormControl(data.codigoPostalCiudad),
          hDepartamento: new FormControl(data.idDepartamento),
        });
      });
    }
  }
}