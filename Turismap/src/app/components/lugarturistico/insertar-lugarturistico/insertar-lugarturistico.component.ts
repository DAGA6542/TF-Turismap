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
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule,MatDatepickerModule],
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
    private LT:LugarturisticoService,
    private ciu: CiudadService,
    private router:Router,
    private formbuilder: FormBuilder,
  ) {}
  ngOnInit(): void {
    this.form = this.formbuilder.group({
      hnombreLugarTuristico: ['', Validators.required],
      hdescripcionLugarTuristico: ['', Validators.required],
      hnumeroLugarTuristico: ['', Validators.required],
      hCiudad: ['', Validators.required],
    });
    this.ciu.list().subscribe((data)=> {
      this.listaciudad = data;
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.lugarturistico.nombreLugarTuristico= this.form.value.hnombreLugarTuristico;
      this.lugarturistico.descripcionLugarTuristico=this.form.value.hdescripcionLugarTuristico;
      this.lugarturistico.numeroLugarTuristico=this.form.value.hnumeroLugarTuristico;
      this.lugarturistico.idCiudad.idCiudad=this.form.value.hCiudad;

      this.LT.insert(this.lugarturistico).subscribe((data) => {
        this.LT.list().subscribe((data) => {
          this.LT.setList(data);

          console.log(data.at)
        });
      });
      this.router.navigate(['lugarturistico']);
    }
  }
}
