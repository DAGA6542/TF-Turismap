import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Comentario } from '../models/comentario';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class ComentarioService {
  
  private url = `${base_url}/comentario`;
  private listaCambio = new Subject<Comentario[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Comentario[]>(this.url);
  }
  insert(c: Comentario) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Comentario[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Comentario>(`${this.url}/${id}`);
  }

  update(tm: Comentario) {
    return this.http.put(this.url, tm);
  }
}
