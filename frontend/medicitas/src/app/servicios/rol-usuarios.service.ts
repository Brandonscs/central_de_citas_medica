import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8081/rol-usuario';

@Injectable({
  providedIn: 'root'
})
export class RolUsuarioService {

  constructor(private http: HttpClient) {}

  listar(): Observable<any> {
    return this.http.get(`${baseUrl}/listarRolUsuario`);
  }

  asignarRol(data: any): Observable<any> {
    return this.http.post(`${baseUrl}/asignarRol`, data);
  }

  eliminar(id: number): Observable<any> {
    return this.http.delete(`${baseUrl}/eliminarRolUsuario?idRolUsuario=${id}`);
  }

  buscarPorUsuario(idUsuario: number): Observable<any> {
    return this.http.get(`${baseUrl}/buscarPorUsuario?idUsuario=${idUsuario}`);
  }

  buscarPorRol(idRol: number): Observable<any> {
    return this.http.get(`${baseUrl}/buscarPorRol?idRol=${idRol}`);
  }
}