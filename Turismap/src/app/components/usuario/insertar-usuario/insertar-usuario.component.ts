import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl, ReactiveFormsModule,FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Usuario } from '../../../models/usuario';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-insertar-usuario',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatButtonModule],
  templateUrl: './insertar-usuario.component.html',
  styleUrl: './insertar-usuario.component.css'
})
export class InsertarUsuarioComponent {
  form:FormGroup = new FormGroup({});
  usuario: Usuario = new Usuario()
  edicion: boolean = false;
  id:number = 0;

  mensaje: string = '';
  constructor(
    private uS:UsuarioService,
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
      idUsuario: [''],
      username: ['', Validators.required],
      nombreUsuario: ['', Validators.required],
      emailUsuario: ['', Validators.required],
      contraseniaUsuario: ['', Validators.required],
      telefonoUsuario: ['', Validators.required],
      enabled: ['', Validators.required]
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.usuario.idUsuario = this.form.value.hidUsuario;
      this.usuario.username= this.form.value.husername;
      this.usuario.nombreUsuario=this.form.value.hnombreUsuario;
      this.usuario.emailUsuario=this.form.value.hemailUsuario;
      this.usuario.contraseniaUsuario=this.form.value.hcontraseniaUsuario;
      this.usuario.telefonoUsuario=this.form.value.htelefonoUsuario;
      this.usuario.enabled=this.form.value.henabled;
    
      if (this.edicion) {
        this.uS.update(this.usuario).subscribe((data)=>{
          this.uS.list().subscribe((data)=>{
            this.uS.setList(data);
          });
        });
      } else {
        this.uS.insert(this.usuario).subscribe((data) => {
          this.uS.list().subscribe((data) => {
            this.uS.setList(data);
          });
        });
      }
      this.router.navigate(['usuario']);
    }
  }
  init() {
    if (this.edicion) {
      this.uS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidUsuario: new FormControl(data.idUsuario),
          husername: new FormControl(data.username),
          hnombreUsuario: new FormControl(data.nombreUsuario),
          hemailUsuario: new FormControl(data.emailUsuario),
          hcontraseniaUsuario: new FormControl(data.contraseniaUsuario),
          htelefonoUsuario: new FormControl(data.telefonoUsuario),
          henabled: new FormControl(data.enabled),
        });
      });
    }
  }
}
