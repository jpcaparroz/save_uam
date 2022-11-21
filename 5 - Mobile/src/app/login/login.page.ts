import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastController } from '@ionic/angular';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { IUsuario } from '../models/IUsuario';
import { UsuarioService } from '../services/usuario.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {



  private urlAPI = `http://localhost:5000/api/usuario`
  email: Observable<IUsuario>;



  constructor(private http: HttpClient, public toastController: ToastController, private route: Router) { }

  ngOnInit() { }

  searchUsuarios(): Observable<IUsuario[]> {
    const url = `${this.urlAPI}`

    return this.http.get<IUsuario>(url).pipe(

      map(retorno => {
        return retorno
      }),

      catchError(erro => this.exibirErro(erro))
    );
  }

  async exibirErro(erro) {
    const toast = await this.toastController.create({
      message: 'Erro ao consultar a API!',
      duration: 2000,
      color: 'danger',
      position: 'middle'
    });
    toast.present();
    return null;
  }

  login() {

    if (this.email) {
      this.searchUsuarios().subscribe(dados => {

        for (let i = 0; i < dados.length; i++) {
          if (this.email.toString() == dados[i].email) {
            this.route.navigate(['/tabs/tab1'], { queryParams: { email: this.email } });
            this.presentToast('Seja bem-vindo!', 'success');
            return;
          }
        }
        this.presentToast('Usuario não encontrado!', 'danger');
      });
    } else {
      this.presentToast('Erro ao logar!', 'danger');
    }
  }

  async presentToast(texto: string, cor: string) {
    const toast = await this.toastController.create({
      message: texto,
      color: cor,
      duration: 2000
    });
    toast.present();
  }

}
