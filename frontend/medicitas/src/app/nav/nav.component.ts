import { Component, OnInit, Input, OnChanges, SimpleChanges  } from '@angular/core';
import { CommonModule, NgIf  } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-nav',
  imports: [RouterOutlet, CommonModule, NgIf],
  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent implements OnInit {

  @Input() rol: string = '';

  paciente = false;
  medico = false;
  auxiliar = false;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.mostrar();
  }

  mostrar() {
    
      if(this.rol == "paciente"){
        this.paciente = true;
        this.medico = false;
        this.auxiliar = false;
      }
      if(this.rol == "medico"){
        this.paciente = false;
        this.medico = true;
        this.auxiliar = false;
      }
      if(this.rol == "auxiliar"){
        this.paciente = false;
        this.medico = false;
        this.auxiliar = true;
      }
  }

  verCitasPaciente() {
    this.router.navigate(['/ver-citas']);
  }

  solicitarCita() {
    this.router.navigate(['/solicitar-cita']);
  }

  verCitasPendientes() {
    this.router.navigate(['/citas-pendientes']);
  }

  verTodasLasCitas() {
    this.router.navigate(['/todas-citas']);
  }

  verCitasDia() {
    this.router.navigate(['/citas-dia']);
  }

  citasPorMedico() {
    this.router.navigate(['/citas-medico']);
  }

  asignarCita() {
    this.router.navigate(['/asignar-cita']);
  }

}
