import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IFilmeAPI, IListaFilmes } from '../models/IFilmeAPI.model';
import { ToastController } from '@ionic/angular';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { cpuUsage } from 'process';
import { element } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {


  private apiURL = 'http://localhost:5000/api/filmeusuario';
  listaFilmes: IListaFilmes;
  filmes: IFilmeAPI[];


  constructor(private http:HttpClient, public toastController:ToastController) { }

  searchFilmes(search: string): Observable<IListaFilmes>{
    

    const url = `${this.apiURL}`;
  
    return  this.http.get<IListaFilmes>(url).pipe(


       map(retorno => {      
        return retorno;
        
      }),
      
      catchError(erro => this.exibirErro(erro)) 
    );
  }


  async exibirErro(erro){
    console.log(erro)
     const toast = await this.toastController.create({
     message: 'Erro ao consultar a API!',
       duration: 2000,
      color:'danger',
      position:'middle'
    });
    toast.present();
  return null;
  }

  
}
