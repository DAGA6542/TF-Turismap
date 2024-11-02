import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Pais } from '../models/pais';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class PaisService {
  private url = `${base_url}/paises`;
  private listaCambio = new Subject<Pais[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Pais[]>(this.url);
  }
  insert(c: Pais) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Pais[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Pais>(`${this.url}/${id}`)
  }

  update(tm: Pais) {
    return this.http.put(this.url, tm);
  }
  
  eliminar(id:number){
    return this.http.delete(`${this.url}/${id}`);
  }
}
