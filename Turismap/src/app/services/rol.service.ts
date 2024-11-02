import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Subject } from 'rxjs';
import { Rol } from '../models/rol';
import { HttpClient } from '@angular/common/http';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class RolService {
  private url = `${base_url}/roles`;
  private listaCambio = new Subject<Rol[]>();

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Rol[]>(this.url);
  }
  insert(c: Rol) {
    return this.http.post(this.url, c)
  }
  getList() {
    return this.listaCambio.asObservable()
  }
  setList(listaNueva: Rol[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id: number) {
    return this.http.get<Rol>(`${this.url}/${id}`);
  }
  update(tm: Rol) {
    return this.http.put(this.url, tm);
  }
}
