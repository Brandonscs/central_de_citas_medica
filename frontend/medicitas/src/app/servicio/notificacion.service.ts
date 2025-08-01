import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Notificacion } from '../entidades/notificacion';

@Injectable({
  providedIn: 'root'
})
export class NotificacionService {

  private servidor = 'http://localhost:8080/notificacion';

  private urlObtenerTodas = `${this.servidor}/obtenerTodasLasNotificaciones`;
  private urlObtenerPorId = `${this.servidor}/obtenerNotificacionPorId`;
  private urlCrear = `${this.servidor}/crearNotificacion`;
  private urlBuscarPorUsuario = `${this.servidor}/buscarNotificacionesPorUsuario`;
  private urlBuscarPorCita = `${this.servidor}/buscarNotificacionesPorCita`;
  private urlBuscarPorTipo = `${this.servidor}/buscarNotificacionesPorTipo`;

  constructor(private http: HttpClient) {}

  obtenerTodas(): Observable<Notificacion[]> {
    return this.http.get<Notificacion[]>(this.urlObtenerTodas);
  }

  obtenerPorId(idNotificacion: number): Observable<Notificacion> {
    return this.http.get<Notificacion>(`${this.urlObtenerPorId}?idNotifcacion=${idNotificacion}`);
  }

  crear(notificacion: Notificacion): Observable<Notificacion> {
    return this.http.post<Notificacion>(this.urlCrear, notificacion);
  }

  buscarPorUsuario(idUsuario: number): Observable<Notificacion[]> {
    return this.http.get<Notificacion[]>(`${this.urlBuscarPorUsuario}?idUsuario=${idUsuario}`);
  }

  buscarPorCita(idCita: number): Observable<Notificacion[]> {
    return this.http.get<Notificacion[]>(`${this.urlBuscarPorCita}?idCita=${idCita}`);
  }

  buscarPorTipo(tipo: string): Observable<Notificacion[]> {
    return this.http.get<Notificacion[]>(`${this.urlBuscarPorTipo}?tipo=${tipo}`);
  }
}

