import { EstadoCita } from './estado-cita';

export class Cita {
  id: number;
  idUsuario: number;
  idMedico: number;
  idEps: number;
  idEstado: EstadoCita;
  fechaHora: Date;
  numeroAutorizacion: string;
  observaciones: string;
  fechaCreacion: Date;
  fechaActualizacion: Date;

  constructor() {
    this.id = 0;
    this.idUsuario = 0;
    this.idMedico = 0;
    this.idEps = 0;
    this.idEstado = new EstadoCita();
    this.fechaHora = new Date();
    this.numeroAutorizacion = '';
    this.observaciones = '';
    this.fechaCreacion = new Date();
    this.fechaActualizacion = new Date();
  }
}
