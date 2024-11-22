import { CommonModule, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { LugarTuristico } from '../../../models/lugarturistico';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { Ciudad } from '../../../models/ciudad';
import { CiudadService } from '../../../services/ciudad.service';

@Component({
  selector: 'app-insertar-lugarturistico',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatDatepickerModule],
  templateUrl: './insertar-lugarturistico.component.html',
  styleUrl: './insertar-lugarturistico.component.css'
})
export class InsertarLugarturisticoComponent implements OnInit{
  form:FormGroup = new FormGroup({});
  listaciudad: Ciudad [] = [];
  lugarturistico: LugarTuristico = new LugarTuristico()
  edicion: boolean = false;
  id:number = 0;
  //

  constructor(
    private ltS: LugarturisticoService,
    private ciuS: CiudadService,
    private router:Router,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute

  ) {}
  ngOnInit(): void {
    this.route.params.subscribe((data:Params)=> {
      this.id = data['id'];
      this.edicion = data['id']  > 0;
      this.init()
    });

    this.form = this.formbuilder.group({
      hnombreLugarTuristico: ['', Validators.required],
      hlatitudLugarTuristico: ['', Validators.required],
      hlongitudLugarTuristico: ['', Validators.required],
      hdescripcionLugarTuristico: ['', Validators.required],
      hnumeroLugarTuristico: ['', Validators.required],
      hCiudad: ['', Validators.required],
    });
    this.ciuS.list().subscribe((data)=> {
      this.listaciudad = data;
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.lugarturistico.idLugar= this.form.value.hidLugarTuristico;
      this.lugarturistico.nombreLugar= this.form.value.hnombreLugarTuristico;
      this.lugarturistico.latitudLugar = this.form.value.hlatitudLugarTuristico;
      this.lugarturistico.longitudLugar = this.form.value.hlongitudLugarTuristico;
      this.lugarturistico.descripcionLugar=this.form.value.hdescripcionLugarTuristico;
      this.lugarturistico.numeroLugar=this.form.value.hnumeroLugarTuristico;
      this.lugarturistico.idCiudad.idCiudad=this.form.value.hCiudad;

      if (this.edicion) {
        this.ltS.update(this.lugarturistico).subscribe((data)=>{
          this.ltS.list().subscribe((data)=>{
            this.ltS.setList(data);
          });
        });
      } else {
        this.ltS.insert(this.lugarturistico).subscribe((data) => {
          this.ltS.list().subscribe((data) => {
            this.ltS.setList(data);
          });
        });
      }
      this.router.navigate(['lugarturistico']);
    }
  }
  init() {
    if (this.edicion) {
      this.ltS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidLugarTuristico: new FormControl(data.idLugar),
          hnombreLugarTuristico: new FormControl(data.nombreLugar),
          hlatitudLugarTuristico: new FormControl(data.latitudLugar),
          hlongitudLugarTuristico: new FormControl(data.longitudLugar),
          hdescripcionLugarTuristico: new FormControl(data.descripcionLugar),
          hnumeroLugarTuristico: new FormControl(data.numeroLugar),
          hidCiudad: new FormControl(data.idCiudad),
        });
      });
    }
  }
}