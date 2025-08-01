import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface EPS {
  id?: number;
  nombre: string;
  nit: string;
  telefono: string;
  direccion: string;
  email: string;
  fechaCreacion?: Date;
  activo?: boolean;
}

@Injectable({ providedIn: 'root' })
export class EpsService {
  private apiUrl = 'http://localhost:8080/eps';

  constructor(private http: HttpClient) {}

  listarTodas(): Observable<EPS[]> {
    return this.http.get<EPS[]>(`${this.apiUrl}/listarEPS`);
  }

  listarActivas(): Observable<EPS[]> {
    return this.http.get<EPS[]>(`${this.apiUrl}/listarEPSActivas`);
  }

  buscarPorId(id: number): Observable<EPS> {
    return this.http.get<EPS>(`${this.apiUrl}/buscarPorId?id=${id}`);
  }

  buscarPorNit(nit: string): Observable<EPS> {
    return this.http.get<EPS>(`${this.apiUrl}/buscarPorNit?nit=${nit}`);
  }

  crear(eps: EPS): Observable<EPS> {
    return this.http.post<EPS>(`${this.apiUrl}/crearEPS`, eps);
  }

  actualizar(id: number, eps: EPS): Observable<EPS> {
    return this.http.put<EPS>(`${this.apiUrl}/actualizarEPS?id=${id}`, eps);
  }

  eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/eliminarEPS?id=${id}`);
  }
}