import { Injectable } from '@angular/core';
import { environment } from '../../environments/environments';
import { Subject } from 'rxjs';
import { MenbresiaVIP } from '../models/menbresiavip';
import { HttpClient } from '@angular/common/http';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class MenbresiavipService {
  private url = `${base_url}/menbresiavip`;
  private listaCambio = new Subject<MenbresiaVIP[]>();
  
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<MenbresiaVIP[]>(this.url);
  }
  insert(c: MenbresiaVIP) {
    return this.http.post(this.url, c);
  }
  getList() {
    return this.listaCambio.asObservable();
  }

  setList(listaNueva: MenbresiaVIP[]) {
    this.listaCambio.next(listaNueva);
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }
  listId(id:number){
    return this.http.get<MenbresiaVIP>(`${this.url}/${id}`);
  }

  update(tm: MenbresiaVIP) {
    return this.http.put(this.url, tm);
  }
}
