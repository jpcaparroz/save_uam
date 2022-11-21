import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IFilmeAPI, IListaFilmes } from '../models/IFilmeAPI.model';
import { DadosService } from '../services/dados.service';
import { FilmeService } from '../services/filme.service';



@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
  
})
export class Tab1Page implements OnInit {

  titulo = 'Save'

  

  listaFilmesx: IListaFilmes;
  listaFilmes: IFilmeAPI[];


  constructor(public dadosService: DadosService, public filmeService: FilmeService, public route: Router) { }


  searchFilmes(evento: any) {
    const search = evento.target.value;
    
    if (search && search.trim() != '') {

    
      let email = window.location.href.split('=').pop();

      this.filmeService.searchFilmes(email).subscribe(dados => {

        var listToObjects = Object.setPrototypeOf(dados, Object.prototype)
        var listObjectsFiltred = []

      

        for (let index = 0; index < listToObjects.length; index++) {
          var element = listToObjects[index];

          if (element.emailUsuario == email) {

            if (element.nomeFilme.toString().toLowerCase().search(search.toLowerCase()) >= 0) {

              listObjectsFiltred.push(element)
            }
          }

        }

        this.listaFilmes = listObjectsFiltred;
        return this.listaFilmes;
      });
    }
  }

  exibirFilme(filme: IFilmeAPI) {
    this.dadosService.guardarDados('filme', filme);
    this.route.navigateByUrl('/dados-filme');
  }

  ngOnInit() {
    this.listaFilmes = this.dadosService.pegarDados('filme');
    console.log('nomeFilme', this.listaFilmes)
  }

  

}
