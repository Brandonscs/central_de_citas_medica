import { NavComponent } from './nav/nav.component';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [NavComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'medicitas';
  rolUsuario: string = 'medico';

  ngOnInit(): void {
      
  }
}
