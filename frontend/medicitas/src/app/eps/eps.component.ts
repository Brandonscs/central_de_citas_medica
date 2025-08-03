import { Component } from '@angular/core';
import { EpsService, EPS } from '../servicios/eps.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-eps',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './eps.component.html',
})
export class EpsComponent {
  epsList: EPS[] = [];
  nuevaEPS: EPS = { nombre: '', nit: '', telefono: '', direccion: '', email: '' };
  modoEdicion = false;
  buscarId = '';
  buscarNit = '';
  idEnEdicion: number | null = null;

  constructor(private epsService: EpsService) {}

  listar() {
    this.epsService.listarTodas().subscribe(data => this.epsList = data);
  }

  listarActivas() {
    this.epsService.listarActivas().subscribe(data => this.epsList = data);
  }

  guardar() {
    if (this.modoEdicion && this.idEnEdicion !== null) {
      this.epsService.actualizar(this.idEnEdicion, this.nuevaEPS).subscribe(() => {
        this.reset();
        this.listar();
      });
    } else {
      this.epsService.crear(this.nuevaEPS).subscribe(() => {
        this.reset();
        this.listar();
      });
    }
  }

  eliminar(id: number) {
    this.epsService.eliminar(id).subscribe(() => this.listar());
  }

  buscarPorId() {
    const id = Number(this.buscarId);
    if (!isNaN(id)) {
      this.epsService.buscarPorId(id).subscribe(data => this.epsList = data ? [data] : []);
    }
  }

  buscarPorNit() {
    if (this.buscarNit.trim()) {
      this.epsService.buscarPorNit(this.buscarNit).subscribe(data => this.epsList = data ? [data] : []);
    }
  }

  cargarParaEditar(eps: EPS) {
    this.nuevaEPS = { ...eps };
    this.modoEdicion = true;
    this.idEnEdicion = eps.id ?? null;
  }

  reset() {
    this.nuevaEPS = { nombre: '', nit: '', telefono: '', direccion: '', email: '' };
    this.modoEdicion = false;
    this.idEnEdicion = null;
  }
}