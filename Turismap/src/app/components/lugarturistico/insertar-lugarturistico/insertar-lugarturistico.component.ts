import { CommonModule, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { LugarTuristico } from '../../../models/lugarturistico';
import { LugarturisticoService } from '../../../services/lugarturistico.service';

@Component({
  selector: 'app-insertar-lugarturistico',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule],
  templateUrl: './insertar-lugarturistico.component.html',
  styleUrl: './insertar-lugarturistico.component.css'
})
export class InsertarLugarturisticoComponent {
  form:FormGroup = new FormGroup({});
  lugarturistico: LugarTuristico = new LugarTuristico()
  edicion: boolean = false;
  id:number = 0;
  //
  constructor(
    private LT:LugarturisticoService,
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
      hidLugarTuristico: [''],
      hnombreLugarTuristico: ['', Validators.required],
      hdescripcionLugarTuristico: ['', Validators.required],
      hnumeroLugarTuristico: ['', Validators.required],
      hidCiudad: ['', Validators.required],
      
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.lugarturistico.idLugarTuristico = this.form.value.hidLugarTuristico;
      this.lugarturistico.nombreLugarTuristico= this.form.value.hnombreLugarTuristico;
      this.lugarturistico.descripcionLugarTuristico=this.form.value.hdescripcionLugarTuristico;
      this.lugarturistico.numeroLugarTuristico=this.form.value.hnumeroLugarTuristico;
      this.lugarturistico.idCiudad=this.form.value.hidCiudad;
      

    
      if (this.edicion) {
        this.LT.update(this.lugarturistico).subscribe((data)=>{
          this.LT.list().subscribe((data)=>{
            this.LT.setList(data);
          });
        });
      } else {
        this.LT.insert(this.lugarturistico).subscribe((data) => {
          this.LT.list().subscribe((data) => {
            this.LT.setList(data);
          });
        });
      }
      this.router.navigate(['lugarturistico']);
    }
  }
  init() {
    if (this.edicion) {
      this.LT.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidLugarTuristico: new FormControl(data.idLugarTuristico),
          hnombreLugarTuristico: new FormControl(data.nombreLugarTuristico),
          hdescripcionLugarTuristico: new FormControl(data.descripcionLugarTuristico),
          hnumeroLugarTuristico: new FormControl(data.numeroLugarTuristico),
          hidCiudad: new FormControl(data.idCiudad),
        });
      });
    }
  }
}
