import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { environment } from '../../environments/environments';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { UsuarioPorComentarioDTO } from '../models/UsuarioPorComentarioDTO';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private url = `${base_url}/usuarios`;
  private listaCambio = new Subject<Usuario[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Usuario[]>(this.url);
  }
  insert(c: Usuario) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: Usuario[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<Usuario>(`${this.url}/${id}`);
  }

  update(tm: Usuario) {
    return this.http.put(this.url, tm);
  }
  buscarUsuariosPorComentariosEnNegocio(nombreNegocio: string): Observable<Usuario[]> {
    const params = new HttpParams().set('nombreNegocio', nombreNegocio);
    return this.http.get<Usuario[]>(`${this.url}/buscarUsuariosPorComentariosEnNegocio`, { params });
  }
  listarUsuariosConMasComentarios(): Observable<UsuarioPorComentarioDTO[]> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.getToken()}`);
    return this.http.get<UsuarioPorComentarioDTO[]>(`${this.url}/listarUsuariosConMasComentarios`, { headers });
  }

  private getToken(): string {
    return localStorage.getItem('token') || '';
  }
}
