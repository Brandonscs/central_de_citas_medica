import { Component, OnInit } from '@angular/core';
import { NavComponent } from '../nav/nav.component';

@Component({
  selector: 'app-prueba',
  imports: [NavComponent],
  templateUrl: './prueba.component.html',
  styleUrl: './prueba.component.css'
})
export class PruebaComponent implements OnInit{

    rolUsuario: string = '';

    ngOnInit(): void {
        this.rolUsuario = 'medico'
    }
}
