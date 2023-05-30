/* eslint-disable @typescript-eslint/naming-convention */
export interface IFilmeAPI{
    posterFilme?:string;
    anoFilme?: string;
    emailUsuario?: string;
    id?: number;
    nomeFilme?: string;
    notaFilme?:number;
}

export interface IListaFilmes{
    results: IFilmeAPI[];
}
