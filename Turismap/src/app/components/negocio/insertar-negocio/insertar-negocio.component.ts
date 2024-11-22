import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl, ReactiveFormsModule,FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { Negocio } from '../../../models/negocio';
import { NegocioService } from '../../../services/negocio.service';

@Component({
  selector: 'app-insertar-negocio',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule],
  templateUrl: './insertar-negocio.component.html',
  styleUrl: './insertar-negocio.component.css'
})
export class InsertarNegocioComponent {
  form: FormGroup = new FormGroup({});
  negocio: Negocio = new Negocio();
  edicion: boolean = false;
  id: number = 0;

  mensaje: string = '';
  listaValidos: { value: boolean; viewValue: string }[] = [
    { value: true, viewValue: 'Sí' },
    { value: false, viewValue: 'No' },
  ];

  constructor(
    private nS: NegocioService,
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
      hidNegocio: [''],
      hnombreNegocio: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$')]],// Solo letras y espacios
      hlatitudNegocio: ['', [Validators.required, Validators.pattern('^-?([1-8]?[0-9](\\.\\d+)?|90(\\.0+)?)$')]],// Latitud válida
      hlongitudNegocio: ['', [Validators.required, Validators.pattern('^-?(1[0-7][0-9](\\.\\d+)?|180(\\.0+)?|[0-9]?[0-9](\\.\\d+)?)$')]],// Longitud válida
      hhorarioNegocio: ['', Validators.required],
      hnumeroTelefonoNegocio: ['', [Validators.required, Validators.minLength(9), Validators.pattern('^[0-9]+$')]],// Solo números
      hcalificacionNegocio: ['', [Validators.required, Validators.pattern('^[0-5](\\.[0-9]+)?$')]],// Calificación de 0 a 5
      hdescripcionNegocio: ['', [Validators.required, Validators.minLength(10)]],// Mínimo 10 caracteres
      hreservaNegocio: ['', Validators.required],
      hidCiudad: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],//Solo números
      hidPromocion: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],//Solo números
    });
  }
  insertar(): void {
    if (this.form.valid) {
      this.negocio.idNegocio = this.form.value.idNegocio;
      this.negocio.nombreNegocio= this.form.value.hnombreNegocio;
      this.negocio.latitudNegocio = this.form.value.hlatitudNegocio;
      this.negocio.longitudNegocio = this.form.value.hlongitudNegocio;
      this.negocio.horarioNegocio=this.form.value.hhorarioNegocio;
      this.negocio.numeroTelefonoNegocio=this.form.value.hnumeroTelefonoNegocio;
      this.negocio.calificacionNegocio=this.form.value.hcalificacionNegocio;
      this.negocio.descripcionNegocio=this.form.value.hdescripcionNegocio;
      this.negocio.reservaNegocio=this.form.value.hreservaNegocio;
      this.negocio.idCiudad.idCiudad=this.form.value.hidCiudad;
      this.negocio.idPromocion.idPromocion=this.form.value.hidPromocion;
    
      if (this.edicion) {
        this.nS.update(this.negocio).subscribe((data)=>{
          this.nS.list().subscribe((data)=>{
            this.nS.setList(data);
          });
        });
      } else {
        this.nS.insert(this.negocio).subscribe((data) => {
          this.nS.list().subscribe((data) => {
            this.nS.setList(data);
          });
        });
      }
      this.router.navigate(['negocio']);
    }
  }
  init() {
    if (this.edicion) {
      this.nS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidNegocio: new FormControl(data.idNegocio),
          hnombreNegocio: new FormControl(data.nombreNegocio),
          hlatitudNegocio: new FormControl(data.latitudNegocio),
          hlongitudNegocio: new FormControl(data.longitudNegocio),
          hhorarioNegocio: new FormControl(data.horarioNegocio),
          hnumeroTelefonoNegocio: new FormControl(data.numeroTelefonoNegocio),
          hcalificacionNegocio: new FormControl(data.calificacionNegocio),
          hdescripcionNegocio: new FormControl(data.descripcionNegocio),
          hreservaNegocio: new FormControl(data.reservaNegocio),
          hidCiudad: new FormControl(data.idCiudad),
          hidPromocion: new FormControl(data.idPromocion),
        });
      });
    }
  }
}
