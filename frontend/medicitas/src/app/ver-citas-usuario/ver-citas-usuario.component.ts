import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from '../nav/nav.component';

@Component({
  selector: 'app-ver-citas-usuario',
  standalone: true,
  imports: [CommonModule, NavComponent],
  templateUrl: './ver-citas-usuario.component.html',
  styleUrls: ['./ver-citas-usuario.component.css']
})
export class VerCitasUsuarioComponent {
  citas = [
    {
      medico: 'Dr. Juan Pérez',
      fecha: '2025-08-05',
      numeroAutorizacion: '123456',
      fechaCreacion: '2025-08-01',
      fechaActualizacion: '2025-08-02',
      estado: 'Pendiente',
      observaciones: 'Primera consulta'
    },
    {
      medico: 'Dra. Ana Gómez',
      fecha: '2025-08-10',
      numeroAutorizacion: '654321',
      fechaCreacion: '2025-07-30',
      fechaActualizacion: '2025-08-01',
      estado: 'Confirmada',
      observaciones: 'Seguimiento'
    }
  ];

  cancelarCita(index: number) {
    this.citas[index].estado = 'Cancelada';
    this.citas[index].fechaActualizacion = new Date().toISOString().split('T')[0];
  }
}