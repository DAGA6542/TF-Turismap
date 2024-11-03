import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl, ReactiveFormsModule,FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Ciudad } from '../../../models/ciudad';
import { CiudadService } from '../../../services/ciudad.service';

@Component({
  selector: 'app-insertar-ciudad',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule],
  templateUrl: './insertar-ciudad.component.html',
  styleUrl: './insertar-ciudad.component.css'
})
export class InsertarCiudadComponent {
  form:FormGroup = new FormGroup({});
  ciudad: Ciudad = new Ciudad()
  edicion: boolean = false;
  id:number = 0;

  mensaje: string = '';

  constructor(
    private cS: CiudadService,
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
      hidCiudad: [''],
      hnombreCiudad: ['', Validators.required],
      hpoblacionCiudad: ['', Validators.required],
      hsuperficieCiudad: ['', Validators.required],
      hlatitudCiudad: ['', Validators.required],
      hlongitudCiudad: ['', Validators.required],
      hcodigoPostalCiudad: ['', Validators.required],
      hidDepartamento: ['', Validators.required],
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.ciudad.idCiudad = this.form.value.hidCiudad;
      this.ciudad.nombreCiudad= this.form.value.hnombreCiudad;
      this.ciudad.poblacionCiudad=this.form.value.hpoblacionCiudad;
      this.ciudad.superficieCiudad=this.form.value.hsuperficieCiudad;
      this.ciudad.latitudCiudad=this.form.value.hlatitudCiudad;
      this.ciudad.longitudCiudad=this.form.value.hlongitudCiudad;
      this.ciudad.codigoPostalCiudad=this.form.value.hcodigoPostalCiudad;
      this.ciudad.idDepartamento=this.form.value.hidDepartamento;
    
      if (this.edicion) {
        this.cS.update(this.ciudad).subscribe((data)=>{
          this.cS.list().subscribe((data)=>{
            this.cS.setList(data);
          });
        });
      } else {
        this.cS.insert(this.ciudad).subscribe((data) => {
          this.cS.list().subscribe((data) => {
            this.cS.setList(data);
          });
        });
      }
      this.router.navigate(['ciudad']);
    }
  }
  init() {
    if (this.edicion) {
      this.cS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidCiudad: new FormControl(data.idCiudad),
          hnombreCiudad: new FormControl(data.nombreCiudad),
          hpoblacionCiudad: new FormControl(data.poblacionCiudad),
          hsuperficieCiudad: new FormControl(data.superficieCiudad),
          hlatitudCiudad: new FormControl(data.latitudCiudad),
          hlongitudCiudad: new FormControl(data.longitudCiudad),
          hcodigoPostalCiudad: new FormControl(data.codigoPostalCiudad),
          hidDepartamento: new FormControl(data.idDepartamento)
        });
      });
    }
  }
}
