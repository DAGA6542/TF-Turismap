import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { PaisService } from '../../../services/pais.service';
import { Pais } from '../../../models/pais';

@Component({
  selector: 'app-insertar-pais',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink],
  templateUrl: './insertar-pais.component.html',
  styleUrl: './insertar-pais.component.css'
})
export class InsertarPaisComponent {
  form:FormGroup = new FormGroup({});
  tipometa: Pais = new Pais()
  mensaje: string = '';
  edicion: boolean = false;
  id:number = 0;
  //
  codigoIsoPais: String = "";
    continentePais: String = "";
    capitalPais: String = "";
    monedaPais: String = "";
    idiomaOficialPais: String = "";
    poblacionPais: number = 0;
    superficiePais: number = 0;

  constructor(
    private tmS:PaisService,
    private router:Router,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.route.params.subscribe((data:Params)=> {
      this.id = data['id'];
      this.edicion = data['id'] !=null;
      
    });

    this.form = this.formbuilder.group({
      codigo: [''],
      nombre: ['', Validators.required],
      codigoIso: ['', Validators.required],
      continente: ['', Validators.required],
      capital: ['', Validators.required],
      moneda: ['', Validators.required],
      idiomaOficial: ['', Validators.required],
      poblacion: ['', Validators.required],
      superficie: ['', Validators.required],
    });
  }

  aceptar(): void {
    if (this.form.valid) {
      this.tipometa.idPais = this.form.value.codigo;
      this.tipometa.nombrePais= this.form.value.nombre
    
    if (this.edicion) {
      this.tmS.modificar(this.tipometa).subscribe((data)=>{
        this.tmS.list().subscribe((data)=>{
          this.tmS.setList(data);
        });
      });
    } else {
      this.tmS.insert(this.tipometa).subscribe((data) => {
        this.tmS.list().subscribe((data) => {
          this.tmS.setList(data);
        });
      });
    }
    this.router.navigate(['tipometa']);
  }
  }
  init() {
    if (this.edicion) {
      this.tmS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          codigo: new FormControl(data.idPais),
          nombre: new FormControl(data.nombrePais),
        });
      });
    }
  }
}
