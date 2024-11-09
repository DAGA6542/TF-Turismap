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
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-insertar-usuario',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatButtonModule, MatSnackBarModule],
  templateUrl: './insertar-usuario.component.html',
  styleUrl: './insertar-usuario.component.css'
})
export class InsertarUsuarioComponent {
  form:FormGroup = new FormGroup({});
  usuario: Usuario = new Usuario()
  edicion: boolean = false;
  id:number = 0;

  mensaje: string = '';

  listaValidos: { value: boolean; viewValue: string }[] = [
    { value: true, viewValue: 'Sí' },
    { value: false, viewValue: 'No' },
  ];

  constructor(
    private uS:UsuarioService,
    private router:Router,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {}
  ngOnInit(): void {
    this.route.params.subscribe((data:Params)=> {
      this.id  = data['id'];
      this.edicion = data['id']  > 0;
      this.init()
    });

    this.form = this.formbuilder.group({
      idUsuario: [''],
      username: ['', Validators.required],
      nombreUsuario: ['', Validators.required],
      emailUsuario: ['', [Validators.required, Validators.email]],
      contraseniaUsuario: ['', Validators.required],
      telefonoUsuario: ['', [Validators.required, Validators.minLength(9), Validators.pattern('^[0-9]+$')]],
      enabled: ['', Validators.required],
    });
    
  }

  insertar(): void {
    if (this.form.valid) {
      this.usuario.idUsuario = this.form.value.idUsuario;
      this.usuario.username = this.form.value.username;
      this.usuario.nombreUsuario = this.form.value.nombreUsuario;
      this.usuario.emailUsuario = this.form.value.emailUsuario;
      this.usuario.contraseniaUsuario = this.form.value.contraseniaUsuario;
      this.usuario.telefonoUsuario = this.form.value.telefonoUsuario;
      this.usuario.enabled = this.form.value.enabled;
  
      if (this.edicion) {
        this.uS.update(this.usuario).subscribe(() => {
          this.uS.list().subscribe((data) => {
            this.uS.setList(data);
            this.snackBar.open('Usuario actualizado con éxito', 'Cerrar', {
              duration: 2000,
            });
            this.router.navigate(['usuario']);
          });
        });
      } else {
        this.uS.insert(this.usuario).subscribe(() => {
          this.uS.list().subscribe((data) => {
            this.uS.setList(data);
            this.snackBar.open('Usuario registrado con éxito', 'Cerrar', {
              duration: 2000,
            });
            this.router.navigate(['usuario']);
          });
        });
      }
    } else {
      this.form.markAllAsTouched();
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
