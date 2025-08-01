import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Auditoria {
  id?: number;
  tablaAfectada: string;
  accion: string;
  idRegistro: number;
  usuario?: any;
  fechaAccion?: Date;
  datosAnteriores: string;
  datosNuevos: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuditoriaService {
  private baseUrl = 'http://localhost:8080/auditoria';

  constructor(private http: HttpClient) {}

  listar(): Observable<Auditoria[]> {
    return this.http.get<Auditoria[]>(`${this.baseUrl}/listar`);
  }

  buscarPorId(id: number): Observable<Auditoria> {
    return this.http.get<Auditoria>(`${this.baseUrl}/buscarPorId`, {
      params: new HttpParams().set('idAuditoria', id)
    });
  }

  crear(auditoria: Auditoria, idUsuario: number): Observable<Auditoria> {
    return this.http.post<Auditoria>(`${this.baseUrl}/crear?idUsuario=${idUsuario}`, auditoria);
  }

  buscarPorTabla(tabla: string): Observable<Auditoria[]> {
    return this.http.get<Auditoria[]>(`${this.baseUrl}/buscarPorTabla`, {
      params: new HttpParams().set('tabla', tabla)
    });
  }

  buscarPorUsuario(idUsuario: number): Observable<Auditoria[]> {
    return this.http.get<Auditoria[]>(`${this.baseUrl}/buscarPorUsuario`, {
      params: new HttpParams().set('idUsuario', idUsuario)
    });
  }

  buscarPorAccion(accion: string): Observable<Auditoria[]> {
    return this.http.get<Auditoria[]>(`${this.baseUrl}/buscarPorAccion`, {
      params: new HttpParams().set('accion', accion)
    });
  }

  buscarPorFecha(fecha: string): Observable<Auditoria[]> {
    return this.http.get<Auditoria[]>(`${this.baseUrl}/buscarPorFecha`, {
      params: new HttpParams().set('fecha', fecha)
    });
  }
}