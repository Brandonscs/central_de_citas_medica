export class Usuario {
  id?: number;
  nombreCompleto: string = '';
  identificacion: string = '';
  telefono?: string;
  direccion?: string;
  correo: string = '';
  fechaNacimiento?: Date;
  rh?: string;
  password: string = '';
  fechaRegistro?: Date;
  activo: boolean = true;
}