import { PruebaComponent } from './prueba/prueba.component';
import { Routes } from '@angular/router';
import { AppComponent } from "./app.component";

export const routes: Routes = [
    {path: 'prueba', component: PruebaComponent},
    {path: '',  component: AppComponent}
];
