import { CommonModule, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Festividad } from '../../../models/festividad';
import { FestividadService } from '../../../services/festividad.service';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { LugarTuristico } from '../../../models/lugarturistico';
import { LugarturisticoService } from '../../../services/lugarturistico.service';

@Component({
  selector: 'app-insertar-festividad',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatDatepickerModule],
  templateUrl: './insertar-festividad.component.html',
  styleUrl: './insertar-festividad.component.css'
})
export class InsertarFestividadComponent implements OnInit {
  form: FormGroup = new FormGroup({});
  listalugarturistico: LugarTuristico[] = [];
  festividad: Festividad = new Festividad()
  edicion: boolean = false;
  id: number = 0;
  //
  constructor(
    private festS: FestividadService,
    private ltS: LugarturisticoService,
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
      hidFestividad: [''],
      hnombreFestividad: ['', Validators.required],
      hdescripcionFestividad: ['', Validators.required],
      hfechaFestividad: ['', Validators.required],
      hidLugarTuristico: ['', Validators.required],
    });
    this.ltS.list().subscribe((data) => {
      this.listalugarturistico = data;
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.festividad.idFestividades = this.form.value.hidFestividad;
      this.festividad.nombreFestividad = this.form.value.hnombreFestividad;
      this.festividad.descripcionFestividad = this.form.value.hdescripcionFestividad;
      this.festividad.fechaFestividad = this.form.value.hfechaFestividad;
      this.festividad.idLugar.idLugar = this.form.value.hidLugarTuristico;

      if (this.edicion) {
        this.festS.update(this.festividad).subscribe((data) => {
          this.festS.list().subscribe((data) => {
            this.festS.setList(data);
          });
        });
      } else {
        this.festS.insert(this.festividad).subscribe((data) => {
          this.festS.list().subscribe((data) => {
            this.festS.setList(data);
          });
        });
      }
      this.router.navigate(['festividad']);
    }
  }
  init() {
    if (this.edicion) {
      this.festS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidFestividad: new FormControl(data.idFestividades),
          hnombreFestividad: new FormControl(data.nombreFestividad),
          hdescripcionFestividad: new FormControl(data.descripcionFestividad),
          hfechaFestividad: new FormControl(data.fechaFestividad),
          hidLugarTuristico: new FormControl(data.idLugar),
        });
      });
    }
  }

}
