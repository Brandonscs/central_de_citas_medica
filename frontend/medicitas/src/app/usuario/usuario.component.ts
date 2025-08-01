import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../servicios/usuario.service';
import { Usuario } from '../entidades/usuario';

@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './usuario.component.html'
})
export class UsuarioComponent implements OnInit {
  usuarios: Usuario[] = [];
  usuarioSeleccionado: Usuario = new Usuario();

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    this.listarUsuarios();
  }

  listarUsuarios(): void {
this.usuarioService.listarUsuarios().subscribe((data: Usuario[]) => {
    this.usuarios = data;
    });
  }

  crearUsuario(): void {
    this.usuarioService.crearUsuario(this.usuarioSeleccionado).subscribe(() => {
      this.listarUsuarios();
      this.usuarioSeleccionado = new Usuario();
    });
  }

  actualizarUsuario(): void {
    if (this.usuarioSeleccionado.id) {
      this.usuarioService.actualizarUsuario(this.usuarioSeleccionado.id, this.usuarioSeleccionado).subscribe(() => {
        this.listarUsuarios();
        this.usuarioSeleccionado = new Usuario();
      });
    }
  }

  eliminarUsuario(id: number): void {
    this.usuarioService.eliminarUsuario(id).subscribe(() => {
      this.listarUsuarios();
    });
  }

  seleccionarUsuario(usuario: Usuario): void {
    this.usuarioSeleccionado = { ...usuario };
  }
}