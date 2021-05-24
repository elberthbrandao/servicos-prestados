import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Cliente } from './clientes/cliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor(
    private http: HttpClient
  ) { }

  salvar(cliente: Cliente) : Observable<Cliente> {
    console.log(cliente)
    return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente);
  }

  getCliente(): Cliente {
    let cliente: Cliente = new Cliente();
    cliente.nome = 'Elberth';
    cliente.cpf = '88888888888';
    return cliente;
  }

}
