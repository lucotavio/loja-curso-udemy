package br.com.storm.loja.backend.repository;

import br.com.storm.loja.backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
