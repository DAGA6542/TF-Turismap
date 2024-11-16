import { CommonModule, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Comentario } from '../../../models/comentario';
import { ComentarioService } from '../../../services/comentario.service';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';

@Component({
  selector: 'app-insertar-comentario',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule,ReactiveFormsModule, MatDatepickerModule],
  templateUrl: './insertar-comentario.component.html',
  styleUrl: './insertar-comentario.component.css'
})
export class InsertarComentarioComponent {
  form:FormGroup = new FormGroup({});
  comentario: Comentario = new Comentario()
  edicion: boolean = false;
  id:number = 0;
  //
  constructor(
    private Comen:ComentarioService,
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
      hidComentario: [''],
      htextoComentario: ['', Validators.required],
      hfechaComentario: ['', Validators.required],
      hidUsuario: ['', Validators.required],
      hidLugarTuristico: ['', Validators.required],
      hidNegocio: ['', Validators.required],
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.comentario.idComentario = this.form.value.hidComentario;
      this.comentario.textoComentario= this.form.value.htextoComentario;
      this.comentario.fechaComentario=this.form.value.hfechaComentario;
      this.comentario.idUsuario.idUsuario=this.form.value.hidUsuario;
      this.comentario.idLugar.idLugar=this.form.value.hidLugarTuristico;
      this.comentario.idNegocio.idNegocio=this.form.value.hidNegocio;


      if (this.edicion) {
        this.Comen.update(this.comentario).subscribe((data)=>{
          this.Comen.list().subscribe((data)=>{
            this.Comen.setList(data);
          });
        });
      } else {
        this.Comen.insert(this.comentario).subscribe((data) => {
          this.Comen.list().subscribe((data) => {
            this.Comen.setList(data);
          });
        });
      }
      this.router.navigate(['comentario']);
    }
  }
  init() {
    if (this.edicion) {
      this.Comen.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidComentario: new FormControl(data.idComentario),
          htextoComentario: new FormControl(data.textoComentario),
          hfechaComentario: new FormControl(data.fechaComentario),
          hidUsuario: new FormControl(data.idUsuario),
          hidLugarTuristico: new FormControl(data.idLugar),
          hidNegocio: new FormControl(data.idNegocio),
        });
      });
    }
  }
}
