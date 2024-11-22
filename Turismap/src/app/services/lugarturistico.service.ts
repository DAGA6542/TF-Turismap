import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Observable, Subject } from 'rxjs';
import { LugarTuristico } from '../models/lugarturistico';
import { HttpClient, HttpParams } from '@angular/common/http';
import { LugarTuristicoPorCiudadDTO } from '../models/LugarTuristicoPorCiudadDTO';
import { LugarTuristicoDTO } from '../models/lugarturisticoDTO';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class LugarturisticoService {
  private url = `${base_url}/lugarturistico`;
  private listaCambio = new Subject<LugarTuristico[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<LugarTuristico[]>(this.url);
  }
  insert(c: LugarTuristico) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }
 

  setList(listaNueva: LugarTuristico[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<LugarTuristico>(`${this.url}/${id}`);
  }

  update(tm: LugarTuristico) {
    return this.http.put(this.url, tm);
  }
  getLugarTuristicoXCiudad(nombreCiudad: string): Observable<LugarTuristicoPorCiudadDTO[]> {
    const params = new HttpParams().set('nombreCiudad', nombreCiudad);
    return this.http.get<LugarTuristicoPorCiudadDTO[]>(`${this.url}/listarlugarturisticoporciudad`, { params });
  }
  getNumeroxLugarTuristicoPorNombre(nombreLugar: string): Observable<LugarTuristico[]> {
    const params = new HttpParams().set('nombreLugarTuristico', nombreLugar); 
    return this.http.get<LugarTuristico[]>(`${this.url}/listarPorNumero`, { params });
  }
  obtenerCoordenadas(): Observable<LugarTuristicoDTO[]> {
    return this.http.get<LugarTuristicoDTO[]>(`${this.url}/listarCoordenadas`);
  }
  
}