import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rol } from '../entidades/rol';

@Injectable({
  providedIn: 'root'
})
export class RolService {
  private baseUrl = 'http://localhost:8081/roles';

  constructor(private http: HttpClient) {}

  listarRoles(): Observable<Rol[]> {
    return this.http.get<Rol[]>(`${this.baseUrl}/listarRoles`);
  }

  obtenerRolPorId(idRol: number): Observable<Rol> {
    return this.http.get<Rol>(`${this.baseUrl}/obtenerRolPorId`, {
      params: { idRol: idRol.toString() }
    });
  }

  crearRol(rol: Rol): Observable<Rol> {
    return this.http.post<Rol>(`${this.baseUrl}/crearRol`, rol);
  }

  actualizarRol(idRol: number, rol: Rol): Observable<Rol> {
    return this.http.put<Rol>(`${this.baseUrl}/actualizarRol`, rol, {
      params: { idRol: idRol.toString() }
    });
  }

  eliminarRol(idRol: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/eliminarRol`, {
      params: { idRol: idRol.toString() }
    });
  }

  buscarPorNombre(nombre: string): Observable<Rol> {
    return this.http.get<Rol>(`${this.baseUrl}/buscarPorNombre`, {
      params: { nombre }
    });
  }

  listarActivos(): Observable<Rol[]> {
    return this.http.get<Rol[]>(`${this.baseUrl}/listarActivos`);
  }
}