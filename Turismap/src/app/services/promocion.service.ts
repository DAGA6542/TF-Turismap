import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Promocion } from '../models/promocion';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class PromocionService {
  private url = `${base_url}/promocion`;
  private listaCambio = new Subject<Promocion[]>();

  constructor(private http: HttpClient) { }

  list() {
    return this.http.get<Promocion[]>(this.url);
  }
  insert(c: Promocion) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Promocion[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id: number) {
    return this.http.get<Promocion>(`${this.url}/${id}`);
  }
  update(tm: Promocion) {
    return this.http.put(this.url, tm);
  }
}
