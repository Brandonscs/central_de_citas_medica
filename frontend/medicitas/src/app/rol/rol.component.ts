import { Component, OnInit } from '@angular/core';
import { RolService } from '../servicios/rol.service';
import { Rol } from '../entidades/rol';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-rol',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './rol.component.html'
})
export class RolComponent implements OnInit {
  roles: Rol[] = [];
  rolSeleccionado: Rol = new Rol();

  constructor(private rolService: RolService) {}

  ngOnInit(): void {
    this.listarRoles();
  }

  listarRoles(): void {
    this.rolService.listarRoles().subscribe((data: Rol[]) => {
      this.roles = data;
    });
  }

  crearRol(): void {
    this.rolService.crearRol(this.rolSeleccionado).subscribe(() => {
      this.listarRoles();
      this.rolSeleccionado = new Rol();
    });
  }

  actualizarRol(): void {
    if (this.rolSeleccionado.id) {
      this.rolService.actualizarRol(this.rolSeleccionado.id, this.rolSeleccionado).subscribe(() => {
        this.listarRoles();
        this.rolSeleccionado = new Rol();
      });
    }
  }

  eliminarRol(id: number): void {
    this.rolService.eliminarRol(id).subscribe(() => {
      this.listarRoles();
    });
  }

  seleccionarRol(rol: Rol): void {
    this.rolSeleccionado = { ...rol };
  }
}