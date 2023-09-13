import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-bienvenido',
  templateUrl: './bienvenido.component.html',
  styleUrls: ['./bienvenido.component.css']
})
export class BienvenidoComponent implements OnInit{
  
  candidato = "";
  version = "";
  
  constructor(private service:ServiceService) { }

  
  ngOnInit(): void {
    this.getCandidato();
    this.getVersion();
  }


  getCandidato(){
    this.service.getCandidato().subscribe(
      res => {
        this.candidato = res.candidato;
      },
      error => {
        console.log(error);
      }
    );
  }

  getVersion(){
    this.service.getVersion().subscribe(
      res => {
        this.version = res.version;
      },
      error => {
        console.log(error);
      }
    );
  }




}
