export class Eps {
  id?: number; // opcional al momento de crear
  nombre: string;
  nit: string;
  telefono: string;
  direccion: string;
  email: string;
  fechaCreacion?: Date; // opcional porque lo genera el backend
  activo?: boolean;     // opcional porque por defecto es true
}

