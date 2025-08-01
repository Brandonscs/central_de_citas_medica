export class RolUsuario {
    id?: number;

  usuario: {
    id: number;
    nombreCompleto?: string;
  };

  rol: {
    id: number;
    nombre?: string;
  };

  asignadoPor?: {
    id: number;
    nombreCompleto?: string;
  };

  fechaAsignacion?: Date;
  activo?: boolean;
}
