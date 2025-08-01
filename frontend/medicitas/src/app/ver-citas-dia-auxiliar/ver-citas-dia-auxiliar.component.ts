import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavComponent } from '../nav.component';

@Component({
  selector: 'app-ver-citas-dia-auxiliar',
  standalone: true,
  imports: [CommonModule, NavComponent],
  templateUrl: './ver-citas-dia-auxiliar.component.html',
  styleUrls: ['./ver-citas-dia-auxiliar.component.css']
})
export class VerCitasDiaAuxiliarComponent {
  citasHoy = [
    {
      paciente: 'Carlos López',
      medico: 'Dr. Pérez',
      fecha: '2025-08-01',
      numeroAutorizacion: 'A123',
      fechaCreacion: '2025-07-30',
      fechaActualizacion: '2025-08-01',
      estado: 'Pendiente',
      observaciones: 'Primera vez'
    },
    {
      paciente: 'Lucía Torres',
      medico: 'Dra. Martínez',
      fecha: '2025-08-01',
      numeroAutorizacion: 'B456',
      fechaCreacion: '2025-07-29',
      fechaActualizacion: '2025-08-01',
      estado: 'Asistida',
      observaciones: 'Seguimiento'
    }
  ];

  cancelarCita(index: number) {
    this.citasHoy[index].estado = 'Cancelada';
    this.citasHoy[index].fechaActualizacion = new Date().toISOString().split('T')[0];
  }

  marcarComoAsistida(index: number) {
    this.citasHoy[index].estado = 'Asistida';
    this.citasHoy[index].fechaActualizacion = new Date().toISOString().split('T')[0];
  }
}