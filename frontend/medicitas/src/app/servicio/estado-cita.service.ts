import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EstadoCita } from '../entidades/estado-cita';

@Injectable({
  providedIn: 'root'
})
export class EstadoCitaService {

  constructor(private httpCliente: HttpClient) { }

  private servidor = "http://localhost:8080/estado-cita";
  private urlObtenerTodos = this.servidor + "/obtenerTodos";
  private urlObtenerPorId = this.servidor + "/obtenerPorId";
  private urlCrear = this.servidor + "/crear";
  private urlActualizar = this.servidor + "/actualizar";
  private urlBuscarPorNombre = this.servidor + "/buscarEstadoPorNombre";

  obtenerTodos(): Observable<EstadoCita[]> {
    return this.httpCliente.get<EstadoCita[]>(this.urlObtenerTodos);
  }

  obtenerPorId(idEstado: number): Observable<EstadoCita> {
    return this.httpCliente.get<EstadoCita>(`${this.urlObtenerPorId}?idEstado=${idEstado}`);
  }

  crear(estado: EstadoCita): Observable<EstadoCita> {
    return this.httpCliente.post<EstadoCita>(this.urlCrear, estado);
  }

  actualizar(estado: EstadoCita): Observable<EstadoCita> {
    return this.httpCliente.put<EstadoCita>(this.urlActualizar, estado);
  }

  buscarPorNombre(nombre: string): Observable<EstadoCita> {
    return this.httpCliente.get<EstadoCita>(`${this.urlBuscarPorNombre}?nombre=${nombre}`);
  }
}
