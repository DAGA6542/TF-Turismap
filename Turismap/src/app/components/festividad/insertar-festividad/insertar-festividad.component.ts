import { CommonModule, NgIf } from '@angular/common';
import { Component } from '@angular/core';
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

@Component({
  selector: 'app-insertar-festividad',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule,MatDatepickerModule],
  templateUrl: './insertar-festividad.component.html',
  styleUrl: './insertar-festividad.component.css'
})
export class InsertarFestividadComponent {
  form:FormGroup = new FormGroup({});
  festividad: Festividad = new Festividad()
  edicion: boolean = false;
  id:number = 0;
  //
  constructor(
    private Fest:FestividadService,
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
      idFestividad: [''],
      nombreFestividad: ['', Validators.required],
      descripcionFestividad: ['', Validators.required],
      fechaFestividad: ['', Validators.required],
      idLugarTuristico: ['', Validators.required],
      
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.festividad.idFestividad = this.form.value.hidFestividad;
      this.festividad.nombreFestividad= this.form.value.hnombreFestividad;
      this.festividad.descripcionFestividad=this.form.value.hdescripcionFestividad;
      this.festividad.fechaFestividad=this.form.value.hfechaFestividad;
      this.festividad.idLugarTuristico=this.form.value.hidLugarTuristico;
      

    
      if (this.edicion) {
        this.Fest.update(this.festividad).subscribe((data)=>{
          this.Fest.list().subscribe((data)=>{
            this.Fest.setList(data);
          });
        });
      } else {
        this.Fest.insert(this.festividad).subscribe((data) => {
          this.Fest.list().subscribe((data) => {
            this.Fest.setList(data);
          });
        });
      }
      this.router.navigate(['lugarturistico']);
    }
  }
  init() {  
    if (this.edicion) {
      this.Fest.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidFestividad: new FormControl(data.idFestividad),
          hnombreFestividad: new FormControl(data.nombreFestividad),
          hdescripcionFestividad: new FormControl(data.descripcionFestividad),
          hfechaFestividad: new FormControl(data.fechaFestividad),
          hidLugarTuristico: new FormControl(data.idLugarTuristico),
        });
      });
    }
  }

}
