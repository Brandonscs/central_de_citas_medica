import { Cita } from './cita';

export class Notificacion {
  idNotificacion: number;
  idUsuario: number;
  idCita: Cita;
  tipo: string;
  asunto: string;
  mensaje: string;
  fechaEnvio: Date;

  constructor() {
    this.idNotificacion = 0;
    this.idUsuario = 0;
    this.idCita = new Cita();
    this.tipo = '';
    this.asunto = '';
    this.mensaje = '';
    this.fechaEnvio = new Date();
  }
}

