import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Favorito } from '../../../models/favorito';
import { FavoritoService } from '../../../services/favorito.service';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { Usuario } from '../../../models/usuario';
import { LugarTuristico } from '../../../models/lugarturistico';
import { Negocio } from '../../../models/negocio';
import { UsuarioService } from '../../../services/usuario.service';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { NegocioService } from '../../../services/negocio.service';
@Component({
  selector: 'app-insertar-favorito',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, ReactiveFormsModule, MatDatepickerModule],
  templateUrl: './insertar-favorito.component.html',
  styleUrl: './insertar-favorito.component.css'
})
export class InsertarFavoritoComponent {
  form: FormGroup = new FormGroup({});
  listarUsuario: Usuario[] = [];
  listarLugarTuristico: LugarTuristico[] = [];
  listarNegocio: Negocio[] = [];
  favorito: Favorito = new Favorito()
  edicion: boolean = false;
  id: number = 0;

  mensaje: string = '';

  constructor(
    private fS: FavoritoService,
    private uS: UsuarioService,
    private ltS: LugarturisticoService,
    private nS: NegocioService,
    private router: Router,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute
  ) { }
  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] > 0;
      this.init()
    });

    this.form = this.formbuilder.group({
      hidFavorito: [''],
      hfechaAgregadoFavorito: ['', Validators.required],
      hfechaModificacionFavorito: ['', Validators.required],
      hidUsuario: ['', Validators.required],
      hidLugarTuristico: ['', Validators.required],
      hidNegocio: ['', Validators.required]
    });
    this.uS.list().subscribe((data)=>{
      this.listarUsuario = data;
    })
    this.ltS.list().subscribe((data)=>{
      this.listarLugarTuristico = data;
    })
    this.nS.list().subscribe((data)=>{
      this.listarNegocio = data;
    })
  }

  insertar(): void {
    if (this.form.valid) {
      this.favorito.idFavorito = this.form.value.hidFavorito;
      this.favorito.fechaAgregadoFavorito = this.form.value.hfechaAgregadoFavorito;
      this.favorito.fechaModificacionFavorito = this.form.value.hfechaModificacionFavorito;
      this.favorito.idUsuario.idUsuario = this.form.value.hidUsuario;
      this.favorito.idLugar.idLugar = this.form.value.hidLugarTuristico;
      this.favorito.idNegocio.idNegocio = this.form.value.hidNegocio;

      if (this.edicion) {
        this.fS.update(this.favorito).subscribe((data) => {
          this.fS.list().subscribe((data) => {
            this.fS.setList(data);
          });
        });
      } else {
        this.fS.insert(this.favorito).subscribe((data) => {
          this.fS.list().subscribe((data) => {
            this.fS.setList(data);
          });
        });
      }
      this.router.navigate(['favorito']);
    }
  }
  init() {
    if (this.edicion) {
      this.fS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidFavorito: new FormControl(data.idFavorito),
          hfechaAgregadoFavorito: new FormControl(data.fechaAgregadoFavorito),
          hfechaModificacionFavorito: new FormControl(data.fechaModificacionFavorito),
          hidUsuario: new FormControl(data.idUsuario),
          hidLugarTuristico: new FormControl(data.idLugar),
          hidNegocio: new FormControl(data.idNegocio)
        });
      });
    }
  }
}
