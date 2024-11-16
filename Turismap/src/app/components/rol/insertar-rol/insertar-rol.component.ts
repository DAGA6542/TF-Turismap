import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl, ReactiveFormsModule,FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Rol } from '../../../models/rol';
import { RolService } from '../../../services/rol.service';

@Component({
  selector: 'app-insertar-rol',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule],
  templateUrl: './insertar-rol.component.html',
  styleUrl: './insertar-rol.component.css'
})
export class InsertarRolComponent {
  form:FormGroup = new FormGroup({});
  rol: Rol = new Rol()
  edicion: boolean = false;
  id:number = 0;
  // 
  mensaje: string = '';
  listaRoles: { value: string; viewValue: string }[] = [
    { value: 'ADMIN', viewValue: 'ADMIN' },
    { value: 'JEFE', viewValue: 'JEFE' },
    { value: 'MIENBRO', viewValue: 'MIENBRO' },
  ];
  constructor(
    private rS: RolService,
    private router: Router,
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
      hidRol: [''],
      hnombreRol: ['', Validators.required],
      huser: ['', Validators.required]
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.rol.idRol = this.form.value.hidRol;
      this.rol.nombreRol= this.form.value.hnombreRol;
      this.rol.user.idUsuario=this.form.value.huser;
    
      if (this.edicion) {
        this.rS.update(this.rol).subscribe((data)=>{
          this.rS.list().subscribe((data)=>{
            this.rS.setList(data);
          });
        });
      } else {
        this.rS.insert(this.rol).subscribe((data) => {
          this.rS.list().subscribe((data) => {
            this.rS.setList(data);
          });
        });
      }
      this.router.navigate(['rol']);
    }
  }
  init() {
    if (this.edicion) {
      this.rS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidRol: new FormControl(data.idRol),
          hnombreRol: new FormControl(data.nombreRol),
          huser: new FormControl(data.user.idUsuario),
        });
      });
    }
  }
}
