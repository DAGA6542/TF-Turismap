import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Favorito } from '../models/favorito';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class FavoritoService {
  private url = `${base_url}/favorito`;
  private listaCambio = new Subject<Favorito[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Favorito[]>(this.url);
  }
  insert(c: Favorito) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Favorito[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Favorito>(`${this.url}/${id}`);
  }

  update(tm: Favorito) {
    return this.http.put(this.url, tm);
  }
}
