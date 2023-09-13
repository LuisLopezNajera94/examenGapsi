import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServiceService } from '../service/service.service';

@Component({
  selector: 'app-provedores',
  templateUrl: './provedores.component.html',
  styleUrls: ['./provedores.component.css']
})
export class ProvedoresComponent implements OnInit{

  provedorForm: FormGroup | any;
  provedores: any[] = [];
  page: number = 1;
  total: number = 0;
  provedorDelete;
  error = false;
  succes = false;
  msj = "";
  

  constructor(private service:ServiceService,private formBuilder: FormBuilder) { }
  
  ngOnInit(): void {
    this.crearFormProvedor();
    this.searchProvedores();
    
  }


  

  crearFormProvedor() {
    this.provedorForm = this.formBuilder.group({
      nombre: [null,[Validators.required,Validators.minLength(5),Validators.maxLength(20)]],
      razonSocial: [null,[Validators.required,Validators.minLength(5),Validators.maxLength(20)]],
      descripccion: [null,[Validators.required,Validators.minLength(5),Validators.maxLength(20)]]
    });
  }



  searchProvedores(){
    try {
      this.service.getProvedores(this.page - 1).subscribe(
        res => {
          this.provedores = res.content;
          this.total = res.totalElements;
        },
        error => {
          this.mostrarMsj("Ocurrio un error al consultar los provedores intente de nuevo mas tarde", true, false);
        }
      );
    } catch (error) {
      this.mostrarMsj("Ocurrio un error al consultar los provedores intente de nuevo mas tarde", true, false);

    }
  }

  saveProvedorModal(){
    this.crearFormProvedor();
  }

  deleteprovedorModal(provedor:any){
    this.provedorDelete = provedor.nombre;
  }


  saveProvedor(){

    let objectSave = {
      "nombre": this.provedorForm.get('nombre')?.value,
      "razonSocial": this.provedorForm.get('razonSocial')?.value,
      "direccion": this.provedorForm.get('descripccion')?.value
    }

    this.service.altaProvedor(objectSave).subscribe(
      res => {
        this.mostrarMsj("El provedor fue creado correctamente", false,true); 
        this.page = 1;
        this.searchProvedores();
      },
      error => {
        this.mostrarMsj(error.error.message, true, false);
      }
    );

  }
  



  deleteProvedor(){
    this.service.deleteProvedor(this.provedorDelete).subscribe(
      res => {
        this.mostrarMsj("El provedor fue eliminado correctamente", false,true); 
        this.page = 1;
        this.searchProvedores();
      },
      error => {
        this.mostrarMsj("Ocurrio un error intente de nuevo mas tarde", true, false);
      }
    );
  }


  mostrarMsj(msj, error, succes) {
    this.msj = msj;
    this.error = error;
    this.succes = succes;
    setTimeout(() => {
      this.error = false;
      this.succes = false;
      this.msj = "";
    }, 5000);
  }

  pageChangeEvent(event: number) {
    this.page = event;
    this.searchProvedores();
  }


}
