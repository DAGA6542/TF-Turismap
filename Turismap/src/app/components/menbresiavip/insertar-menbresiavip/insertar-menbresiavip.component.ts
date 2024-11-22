import { MenbresiaVIP } from './../../../models/menbresiavip';
import { CommonModule, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MenbresiavipService } from '../../../services/menbresiavip.service';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';
import { UsuarioService } from '../../../services/usuario.service';
import { Usuario } from '../../../models/usuario';
import { MatCheckboxModule } from '@angular/material/checkbox';


@Component({
  selector: 'app-insertar-menbresiavip',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule, CommonModule, NgIf, MatButtonModule, MatInputModule, ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule, MatDatepickerModule,MatCheckboxModule],
  templateUrl: './insertar-menbresiavip.component.html',
  styleUrl: './insertar-menbresiavip.component.css'
})
export class InsertarMenbresiavipComponent {
  form: FormGroup = new FormGroup({});
  listausuarios: Usuario[] = [];
  membresiavip: MenbresiaVIP = new MenbresiaVIP()
  edicion: boolean = false;
  id: number = 0;
  //
  constructor(
    private membreS: MenbresiavipService,
    private usuS: UsuarioService,
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
      hidMenbresiaVIP: [''],
      htipoMenbresiaVIP: ['', Validators.required],
      hfechaInicioMenbresiaVIP: ['', Validators.required],
      hfechaFinMenbresiaVIP: ['', Validators.required],
      hestadoMenbresiaVIP: [true, Validators.required],
      hbeneficioMenbresiaVIP: ['', Validators.required],
      hidUsuario: ['', Validators.required],
    });
    this.usuS.list().subscribe((data)=>{
      this.listausuarios = data;
    })
  }

  insertar(): void {
    if (this.form.valid) {
      this.membresiavip.idMenbresiaVIP = this.form.value.hidMenbresiaVIP;
      this.membresiavip.tipoMenbresiaVIP = this.form.value.htipoMenbresiaVIP;
      this.membresiavip.fechaInicioMenbresiaVIP = this.form.value.hfechaInicioMenbresiaVIP;
      this.membresiavip.fechaFinMenbresiaVIP = this.form.value.hfechaFinMenbresiaVIP;
      this.membresiavip.estadoMenbresiaVIP = this.form.value.hestadoMenbresiaVIP;
      this.membresiavip.beneficioMenbresiaVIP = this.form.value.hbeneficioMenbresiaVIP;
      this.membresiavip.idUsuario.idUsuario = this.form.value.hidUsuario;


      if (this.edicion) {
        this .membreS.update(this.membresiavip).subscribe((data) => {
          this .membreS.list().subscribe((data) => {
            this .membreS.setList(data);
          });
        });
      } else {
        this .membreS.insert(this.membresiavip).subscribe((data) => {
          this .membreS.list().subscribe((data) => {
            this .membreS.setList(data);
          });
        });
      }
      this.router.navigate(['menbresiavip']);
    }
  }
  init() {
    if (this.edicion) {
      this .membreS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidMenbresiaVIP: new FormControl(data.idMenbresiaVIP),
          htipoMenbresiaVIP: new FormControl(data.tipoMenbresiaVIP),
          hfechaInicioMenbresiaVIP: new FormControl(data.fechaInicioMenbresiaVIP),
          hfechaFinMenbresiaVIP: new FormControl(data.fechaFinMenbresiaVIP),
          hestadoMenbresiaVIP: new FormControl(data.estadoMenbresiaVIP),
          hbeneficioMenbresiaVIP: new FormControl(data.beneficioMenbresiaVIP),
          hidUsuario: new FormControl(data.idUsuario),
        });
      });
    }
  }
}
