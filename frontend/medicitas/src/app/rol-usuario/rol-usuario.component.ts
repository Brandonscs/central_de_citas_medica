import { Component, OnInit } from '@angular/core';
import { RolUsuarioService } from '../servicios/rol-usuarios.service';


@Component({
  selector: 'app-rol-usuario',
  templateUrl: './rol-usuario.component.html'
})
export class RolUsuarioComponent implements OnInit {

  asignaciones: any[] = [];
  nuevaAsignacion = {
    usuario: { id: null },
    rol: { id: null },
    asignadoPor: { id: null },
    activo: true
  };
  idBuscarUsuario = 0;
  idBuscarRol = 0;

  constructor(private servicio: RolUsuarioService) {}

  ngOnInit(): void {
    this.listar();
  }

  listar() {
    this.servicio.listar().subscribe(data => this.asignaciones = data);
  }

  asignar() {
    this.servicio.asignarRol(this.nuevaAsignacion).subscribe(() => {
      this.listar();
      this.nuevaAsignacion = { usuario: { id: null }, rol: { id: null }, asignadoPor: { id: null }, activo: true };
    });
  }

  eliminar(id: number) {
    this.servicio.eliminar(id).subscribe(() => this.listar());
  }

  buscarPorUsuario() {
    this.servicio.buscarPorUsuario(this.idBuscarUsuario).subscribe(data => this.asignaciones = data);
  }

  buscarPorRol() {
    this.servicio.buscarPorRol(this.idBuscarRol).subscribe(data => this.asignaciones = data);
  }
}