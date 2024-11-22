import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,Validators,FormControl, ReactiveFormsModule,FormsModule } from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule, NgIf } from '@angular/common';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { PaisService } from '../../../services/pais.service';
import { Pais } from '../../../models/pais';

@Component({
  selector: 'app-insertar-pais',
  standalone: true,
  imports: [MatFormFieldModule,CommonModule,NgIf, MatButtonModule,MatInputModule,ReactiveFormsModule,
    RouterLink, MatSelectModule, FormsModule],
  templateUrl: './insertar-pais.component.html',
  styleUrl: './insertar-pais.component.css'
})
export class InsertarPaisComponent {
  form:FormGroup = new FormGroup({});
  pais: Pais = new Pais()
  edicion: boolean = false;
  id:number = 0;
  // 
  mensaje: string = '';
  listaContinente: { value: string; viewValue: string }[] = [
    { value: 'Asia', viewValue: 'Asia' },
    { value: 'África', viewValue: 'África' },
    { value: 'América del Norte', viewValue: 'América del Norte' },
    { value: 'América del Sur', viewValue: 'América del Sur' },
    { value: 'Antártida', viewValue: 'Antártida' },
    { value: 'Europa', viewValue: 'Europa' },
    { value: 'Oceanía', viewValue: 'Oceanía' },
  ];
  listaMoneda: { value: string; viewValue: string }[] = [
    { value: 'Dólar americano', viewValue: 'Dólar americano' },
    { value: 'Euro', viewValue: 'Euro' },
    { value: 'Libra esterlina', viewValue: 'Libra esterlina' },
    { value: 'Franco suizo', viewValue: 'Franco suizo' },
    { value: 'Yen japonés', viewValue: 'Yen japonés' },
    { value: 'Dólar hongkonés', viewValue: 'Dólar hongkonés' },
    { value: 'Yuan chino', viewValue: 'Yuan chino' },
    { value: 'Real brasileño', viewValue: 'Real brasileño' },
    { value: 'Rublo ruso', viewValue: 'Rublo ruso' },
    { value: 'Peso mexicano', viewValue: 'Peso mexicano' },
    { value: 'Sol', viewValue: 'Sol' },
  ];
  listaIdioma: { value: string; viewValue: string }[] = [
    { value: 'Inglés', viewValue: 'Inglés' },
    { value: 'Chino mandarín', viewValue: 'Chino mandarín' },
    { value: 'Hindi', viewValue: 'Hindi' },
    { value: 'Español', viewValue: 'Español' },
    { value: 'Francés', viewValue: 'Francés' },
    { value: 'Árabe', viewValue: 'Árabe' },
    { value: 'Bengalí', viewValue: 'Bengalí' },
    { value: 'Portugués', viewValue: 'Portugués' },
    { value: 'Ruso', viewValue: 'Ruso' },
    { value: 'Aleman', viewValue: 'Aleman' },
  ];

  constructor(
    private pS:PaisService,
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
      hidPais: [''],
      hnombrePais: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$')]],// Solo letras y espacios
      hcodigoIsoPais: ['', [Validators.required, Validators.pattern('^[A-Z]{3}$')]],// Longitud de 3 letras mayúsculas
      hcontinentePais: ['', Validators.required],
      hcapitalPais: ['', [Validators.required, Validators.minLength(3), Validators.pattern('^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$')]],// Solo letras y espacios
      hmonedaPais: ['', Validators.required],
      hidiomaOficialPais: ['', Validators.required],
      hpoblacionPais: ['', [Validators.required, Validators.pattern('^[0-9]+$')]],// Solo números positivos
      hsuperficiePais: ['', [Validators.required, Validators.pattern('^[0-9]+(\\.[0-9]+)?$')]],// Números positivos (puede tener decimales)
    });
  }

  insertar(): void {
    if (this.form.valid) {
      this.pais.idPais = this.form.value.hidPais;
      this.pais.nombrePais= this.form.value.hnombrePais;
      this.pais.codigoIsoPais=this.form.value.hcodigoIsoPais;
      this.pais.continentePais=this.form.value.hcontinentePais;
      this.pais.capitalPais=this.form.value.hcapitalPais;
      this.pais.monedaPais=this.form.value.hmonedaPais;
      this.pais.idiomaOficialPais=this.form.value.hidiomaOficialPais;
      this.pais.poblacionPais=this.form.value.hpoblacionPais;
      this.pais.superficiePais=this.form.value.hsuperficiePais;
    
      if (this.edicion) {
        this.pS.update(this.pais).subscribe((data)=>{
          this.pS.list().subscribe((data)=>{
            this.pS.setList(data);
          });
        });
      } else {
        this.pS.insert(this.pais).subscribe((data) => {
          this.pS.list().subscribe((data) => {
            this.pS.setList(data);
          });
        });
      }
      this.router.navigate(['pais']);
    }
  }
  init() {
    if (this.edicion) {
      this.pS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          hidPais: new FormControl(data.idPais),
          hnombrePais: new FormControl(data.nombrePais),
          hcodigoIsoPais: new FormControl(data.codigoIsoPais),
          hcontinentePais: new FormControl(data.continentePais),
          hcapitalPais: new FormControl(data.capitalPais),
          hmonedaPais: new FormControl(data.monedaPais),
          hidiomaOficialPais: new FormControl(data.idiomaOficialPais),
          hpoblacionPais: new FormControl(data.poblacionPais),
          hsuperficiePais: new FormControl(data.superficiePais),
        });
      });
    }
  }
}
