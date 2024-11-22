import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Ciudad } from '../models/ciudad';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { CantidadTurismoxCiudadDTO } from '../models/CantidadTurismoxCiudadDTO';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class CiudadService {
  private url = `${base_url}/ciudades`
  private listaCambio = new Subject<Ciudad[]>();
  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Ciudad[]>(this.url);
  }
  insert(c: Ciudad) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }
  setList(listaNueva: Ciudad[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id: number) {
    return this.http.get<Ciudad>(`${this.url}/${id}`);
  }
  update(tm: Ciudad) {
    return this.http.put(this.url, tm)
  }
  obtenerCantidadTurismoxCiudad(): Observable<CantidadTurismoxCiudadDTO[]> {
    return this.http.get<CantidadTurismoxCiudadDTO[]>(`${this.url}/calcularCantidadTurismoPorCiudad`);
  }
}
