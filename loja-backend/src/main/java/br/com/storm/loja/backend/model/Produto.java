package br.com.storm.loja.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @Column(name = "VALOR")
    private Double valor;
}
