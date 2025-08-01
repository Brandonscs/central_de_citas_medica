import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../entidades/usuario';

@Injectable({ providedIn: 'root' })

export class UsuarioService {
  private baseUrl = 'http://localhost:8080/usuarios';

  constructor(private http: HttpClient) {}

  listarUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.baseUrl}/listarUsuarios`);
  }

  obtenerUsuarioPorId(idUsuario: number): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.baseUrl}/obtenerUsuarioPorId`, {
      params: { idUsuario: idUsuario.toString() }
    });
  }

  crearUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.baseUrl}/crearUsuario`, usuario);
  }

  actualizarUsuario(idUsuario: number, usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${this.baseUrl}/actualizarUsuario`, usuario, {
      params: { idUsuario: idUsuario.toString() }
    });
  }

  eliminarUsuario(idUsuario: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/eliminarUsuario`, {
      params: { idUsuario: idUsuario.toString() }
    });
  }

  buscarPorNombre(nombre: string): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.baseUrl}/buscarPorNombre`, {
      params: { nombre }
    });
  }

  buscarPorCorreo(correo: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.baseUrl}/buscarPorCorreo`, {
      params: { correo }
    });
  }

  buscarPorIdentificacion(identificacion: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.baseUrl}/buscarPorIdentificacion`, {
      params: { identificacion }
    });
  }

  listarActivos(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.baseUrl}/listarActivos`);
  }
}