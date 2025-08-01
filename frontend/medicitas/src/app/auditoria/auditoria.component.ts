  import { Component, inject } from '@angular/core';
  import { CommonModule } from '@angular/common';
  import { FormsModule } from '@angular/forms';
  import { AuditoriaService, Auditoria } from '../servicios/auditoria.service';

  @Component({
    selector: 'app-auditoria',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './auditoria.component.html'
  })
  export class AuditoriaComponent {
    private auditoriaService = inject(AuditoriaService);

    auditorias: Auditoria[] = [];
    nuevaAuditoria: Auditoria = {
      tablaAfectada: '',
      accion: '',
      idRegistro: 0,
      datosAnteriores: '',
      datosNuevos: ''
    };
    idUsuario: number = 1; // cambia este valor según sea necesario

    ngOnInit() {
      this.cargarAuditorias();
    }

    cargarAuditorias() {
      this.auditoriaService.listar().subscribe(data => this.auditorias = data);
    }

    crearAuditoria() {
      this.auditoriaService.crear(this.nuevaAuditoria, this.idUsuario).subscribe(() => {
        this.nuevaAuditoria = {
          tablaAfectada: '',
          accion: '',
          idRegistro: 0,
          datosAnteriores: '',
          datosNuevos: ''
        };
        this.cargarAuditorias();
      });
    }
  }