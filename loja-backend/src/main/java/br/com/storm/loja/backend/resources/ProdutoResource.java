package br.com.storm.loja.backend.resources;

import br.com.storm.loja.backend.model.Produto;
import br.com.storm.loja.backend.repository.ProdutoRepository;
import br.com.storm.loja.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin("*")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto produto = service.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produtos = service.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        Produto produtoRetornado = service.saveOrUpdate(produto);
        return ResponseEntity.ok().body(produtoRetornado);
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto produto){
        Produto produtoRetornado = service.saveOrUpdate(produto);
        return ResponseEntity.ok().body(produtoRetornado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
