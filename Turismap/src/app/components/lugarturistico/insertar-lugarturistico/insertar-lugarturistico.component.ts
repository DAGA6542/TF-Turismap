import { CommonModule, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { RouterLink, RouterModule } from '@angular/router';
import { Ciudad } from '../../../models/ciudad';
import { CiudadService } from '../../../services/ciudad.service';
import { LugarturisticoService } from '../../../services/lugarturistico.service';
import { Router } from '@angular/router';
import { provideNativeDateAdapter } from '@angular/material/core';
import { LugarTuristico } from '../../../models/lugarturistico';

@Component({
  selector: 'app-insertar-lugarturistico',
  standalone: true,
  providers: [provideNativeDateAdapter()],
  imports: [
    MatFormFieldModule,
    CommonModule,
    NgIf,
    MatButtonModule,
    MatInputModule,
    ReactiveFormsModule,
    RouterLink,
    MatSelectModule,
    FormsModule,
    RouterModule],
  templateUrl: './insertar-lugarturistico.component.html',
  styleUrl: './insertar-lugarturistico.component.css'
})
export class InsertarLugarturisticoComponent {
  form: FormGroup = new FormGroup({});
  listaCiudades: Ciudad[] = [];
  idCiudad: Ciudad = new Ciudad();

  constructor(
    private formBuilder: FormBuilder,
    private cS: CiudadService,
    private ltS: LugarturisticoService,
    private router: Router
  ) { 
    this.form = this.formBuilder.group({
      nombreLugar: ['', Validators.required],
      descripcionLugar: ['', Validators.required],
      numeroTelefonoLugar: ['', [Validators.required, Validators.minLength(9), Validators.pattern('^[0-9]+$')]],
      idCiudad: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.cS.list().subscribe((data) => {
      this.listaCiudades = data;
    });
  }
  insertar(): void {
    if (this.form.valid) {
      const lugar: LugarTuristico = {
        idLugar: 0,
        nombreLugar: this.form.value.nombreLugarTuristico,
        descripcionLugar: this.form.value.descripcionLugarTuristico,
        numeroTelefonoLugar: this.form.value.numeroTelefonoLugar,
        idCiudad: this.form.value.idCiudad // Ahora es solo el ID
      };

      this.ltS.insert(lugar).subscribe(
        (response) => {
          console.log('Lugar Turístico registrado con éxito:', response);
          this.router.navigate(['/lugarturistico']);
        },
        (error) => {
          console.error('Error al registrar el lugar turístico:', error);
        }
      );
    }
  }
  
}
