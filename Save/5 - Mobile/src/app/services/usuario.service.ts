import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ToastController } from '@ionic/angular';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { IUsuario } from '../models/IUsuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlAPI = `http://localhost:5000/api/usuario`

  constructor(private http:HttpClient, public toastController:ToastController) { }

  searchUsuarios():Observable<IUsuario>{
    const url= `${this.urlAPI}`
    return this.http.get<IUsuario>(url).pipe(
      map(retorno => retorno),
      catchError(erro => this.exibirErro(erro))
    );
  }

  async exibirErro(erro){
    const toast = await this.toastController.create({
      message: 'Usuario não encontrado!',
      duration: 2000,
      color:'danger',
      position:'middle'
    });
    toast.present();
    return null;
  }
}
