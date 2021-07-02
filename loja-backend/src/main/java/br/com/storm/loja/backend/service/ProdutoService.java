package br.com.storm.loja.backend.service;

import br.com.storm.loja.backend.model.Produto;
import br.com.storm.loja.backend.repository.ProdutoRepository;
import br.com.storm.loja.backend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findById(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado:" + id + "Tipo: " + Produto.class.getName()));
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto saveOrUpdate(Produto produto){
        return repository.save(produto);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
