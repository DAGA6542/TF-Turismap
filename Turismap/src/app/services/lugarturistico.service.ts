import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Subject } from 'rxjs';
import { LugarTuristico } from '../models/lugarturistico';
import { HttpClient } from '@angular/common/http';

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
}
