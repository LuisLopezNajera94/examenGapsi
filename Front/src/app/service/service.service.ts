import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http: HttpClient) { }

  getCandidato():any{
    return this.http.get("http://localhost:8080/candidato");
  }

  getVersion():any{
    return this.http.get("http://localhost:8080/version");
  }

  getProvedores(page:any):any{
    return this.http.get("http://localhost:8080/provedores?page="+page);
  }


  altaProvedor(objectSave:any):any{
    return this.http.post("http://localhost:8080/altaProvedor",objectSave);
  }

  deleteProvedor(nombre:any):any{
    return this.http.delete("http://localhost:8080/deleteProvedor/"+nombre);
  }


}
