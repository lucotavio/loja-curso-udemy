import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';


@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private url = 'http://localhost:8080/produtos/';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Produto[]> {

    return  this.http.get<Produto[]>(`${this.url}`);
  }


  findById(produto: Produto): Observable<Produto> {

    return  this.http.get<Produto>(`${this.url}${produto.id}`)
  }


  save(produto:Produto): Observable<Produto>{
    
    return this.http.post<Produto>(`${this.url}`, produto);
  }


  update(produto:Produto): Observable<Produto>{
    
    return this.http.put<Produto>(`${this.url}`, produto);
  }


  delete(produto: Produto): Observable<void>{
    return this.http.delete<void>(`http://localhost:8080/produtos/${produto.id}`);
  }
}
