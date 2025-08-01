import { Usuario } from '../entidades/usuario'

export class Auditoria {
id?: number; // opcional, si se genera automáticamente
  tablaAfectada: string;
  accion: string;
  idRegistro: number;
  usuario: Usuario;
  fechaAccion: Date;
  datosAnteriores: string;
  datosNuevos: string;
}
