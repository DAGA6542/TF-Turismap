import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Subject } from 'rxjs';
import { Festividad } from '../models/festividad';
import { HttpClient } from '@angular/common/http';
const base_url = environment.base;
@Injectable({
  providedIn: 'root'
})
export class FestividadService {
  private url = `${base_url}/festividad`;
  private listaCambio = new Subject<Festividad[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Festividad[]>(this.url);
  }
  insert(c: Festividad) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Festividad[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Festividad>(`${this.url}/${id}`);
  }

  update(tm: Festividad) {
    return this.http.put(this.url, tm);
  }
}
