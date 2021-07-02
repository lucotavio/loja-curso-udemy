import { Component, OnInit } from '@angular/core';
import { Produto } from '../model/produto';
import { ProdutoService } from '../services/produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  constructor(private service: ProdutoService) { }

  produtos: Produto [] = [];

  produto: Produto = new Produto();

  exibirBotao: boolean = false;

  ngOnInit(): void {
    this.findAll();

  }

  findAll(): void{

    this.service.findAll().subscribe(produto => {
      this.produtos = produto;
    });
  }

  save(produto: Produto): void{

    this.service.save(produto)
    .subscribe(() => {
      this.produto = new Produto();
      this.findAll();
    });
  }

  atualizar(produto: Produto): void{
    this.produto = produto;
    this.exibirBotao = true;
  }

  update(produto: Produto): void{

    this.service.update(produto).subscribe(() => {
      this.findAll();
    });
  }

  delete(produto: Produto): void{
    this.service.delete(produto).subscribe(() => {
      this.findAll();
    });
  }
}
