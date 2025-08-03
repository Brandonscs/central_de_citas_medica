import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cita } from '../entidades/cita';

@Injectable({
  providedIn: 'root'
})
export class CitaService {

  private servidor = "http://localhost:8080/cita";

  private urlObtenerTodas = this.servidor + "/obtenerTodasLasCitas";
  private urlObtenerPorId = this.servidor + "/obtenerCitaPorId";
  private urlCrear = this.servidor + "/crearCita";
  private urlBuscarPendientesUsuario = this.servidor + "/buscarCitasPendientesPorUsuario";
  private urlBuscarUltimaUsuario = this.servidor + "/buscarUltimaCitaPorUsuario";
  private urlBuscarPorMedico = this.servidor + "/buscarCitasPorMedico";
  private urlBuscarPorEstado = this.servidor + "/buscarCitasPorEstado";
  private urlBuscarPorFecha = this.servidor + "/buscarCitasPorFecha";

  constructor(private http: HttpClient) { }

  obtenerTodas(): Observable<Cita[]> {
    return this.http.get<Cita[]>(this.urlObtenerTodas);
  }

  obtenerPorId(idCita: number): Observable<Cita> {
    return this.http.get<Cita>(`${this.urlObtenerPorId}?idCita=${idCita}`);
  }

  crear(cita: Cita): Observable<Cita> {
    return this.http.post<Cita>(this.urlCrear, cita);
  }

  buscarPendientesPorUsuario(idUsuario: number): Observable<Cita[]> {
    return this.http.get<Cita[]>(`${this.urlBuscarPendientesUsuario}?idUsuario=${idUsuario}`);
  }

  buscarUltimaPorUsuario(idUsuario: number): Observable<Cita> {
    return this.http.get<Cita>(`${this.urlBuscarUltimaUsuario}?idUsuario=${idUsuario}`);
  }

  buscarPorMedico(idMedico: number): Observable<Cita[]> {
    return this.http.get<Cita[]>(`${this.urlBuscarPorMedico}?idMedico=${idMedico}`);
  }

  buscarPorEstado(idEstado: number): Observable<Cita[]> {
    return this.http.get<Cita[]>(`${this.urlBuscarPorEstado}?idEstado=${idEstado}`);
  }

  buscarPorFecha(fecha: string): Observable<Cita[]> {
    return this.http.get<Cita[]>(`${this.urlBuscarPorFecha}?fecha=${fecha}`);
  }
}
