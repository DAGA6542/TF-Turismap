import { Component } from '@angular/core';
import { Promocion } from '../../../models/promocion';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { PromocionService } from '../../../services/promocion.service';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'app-insertar-promocion',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule,ReactiveFormsModule, MatDatepickerModule],
  templateUrl: './insertar-promocion.component.html',
  styleUrl: './insertar-promocion.component.css'
})
export class InsertarPromocionComponent {
  form:FormGroup = new FormGroup({});
  promocion: Promocion = new Promocion()
  edicion: boolean = false;
  id:number = 0;

  constructor(
    private promS:PromocionService,
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
      hidPromocion: [''],
      hnombrePromocion: ['', Validators.required],
      hdescripcionPromocion: ['', Validators.required],
      hprecioPromocion: ['', Validators.required],
      hdescuentoPromocion: ['', Validators.required],
      hfechaInicioPromocion: ['', Validators.required],
      hfechaFinPromocion: ['', Validators.required],

    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.promocion.idPromocion = this.form.value.hidPromocion;
      this.promocion.nombrePromocion= this.form.value.hnombrePromocion;
      this.promocion.descripcionPromocion=this.form.value.hdescripcionPromocion;
      this.promocion.precioPromocion=this.form.value.hprecioPromocion;
      this.promocion.descuentoPromocion=this.form.value.hdescuentoPromocion;
      this.promocion.fechaInicioPromocion=this.form.value.hfechaInicioPromocion;
      this.promocion.fechaFinPromocion=this.form.value.hfechaFinPromocion;

    
      if (this.edicion) {
        this.promS.update(this.promocion).subscribe((data)=>{
          this.promS.list().subscribe((data)=>{
            this.promS.setList(data);
          });
        });
      } else {
        this.promS.insert(this.promocion).subscribe((data) => {
          this.promS.list().subscribe((data) => {
            this.promS.setList(data);
          });
        });
      }
      this.router.navigate(['promocion']);
    }
  }
  init() {
    if (this.edicion) {
      this.promS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidPromocion: new FormControl(data.idPromocion),
          hnombrePromocion: new FormControl(data.nombrePromocion),
          hdescripcionPromocion: new FormControl(data.descripcionPromocion),
          hprecioPromocion: new FormControl(data.precioPromocion),
          hdescuentoPromocion: new FormControl(data.descuentoPromocion),
          hfechaInicioPromocion: new FormControl(data.fechaInicioPromocion),
          hfechaFinPromocion: new FormControl(data.fechaFinPromocion),
        });
      });
    }
  }
}