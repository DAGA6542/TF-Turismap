import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Negocio } from '../models/negocio';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class NegocioService {
  private url = `${base_url}/negocio`;
  private listaCambio = new Subject<Negocio[]>();

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Negocio[]>(this.url);
  }
  insert(c: Negocio) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Negocio[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Negocio>(`${this.url}/${id}`);
  }

  update(tm: Negocio) {
    return this.http.put(this.url, tm);
}
}
