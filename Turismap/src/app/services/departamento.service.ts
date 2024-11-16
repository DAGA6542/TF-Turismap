import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Departamento } from '../models/departamento';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {
  private url = `${base_url}/departamentos`;
  private listaCambio = new Subject<Departamento[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Departamento[]>(this.url);
  }
  insert(c: Departamento) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Departamento[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Departamento>(`${this.url}/${id}`);
  }

  update(tm: Departamento) {
    return this.http.put(this.url, tm);
  }
}
