import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-mensaje',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './mensaje.component.html',
  styleUrls: ['./mensaje.component.css']
})
export class MensajeComponent {
  @Input() titulo: string = '';
  @Input() detalle: string = '';
  @Input() tipo: 'exito' | 'error' = 'exito';

  visible: boolean = true;

  cerrar() {
    this.visible = false;
  }
}