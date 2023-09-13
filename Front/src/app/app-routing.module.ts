import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BienvenidoComponent } from './bienvenido/bienvenido.component';
import { ProvedoresComponent } from './provedores/provedores.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/bienvenido'
  },
  {
    path: 'bienvenido',
    component: BienvenidoComponent
  },
  {
    path: 'provedores',
    component: ProvedoresComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
