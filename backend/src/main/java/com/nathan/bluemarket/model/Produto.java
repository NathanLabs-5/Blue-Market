package com.nathan.bluemarket.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120)
    private String nome;
    @Column(length = 1000)
    private String descricao;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    @Column(nullable = false)
    private Integer estoque;
    @Column(nullable = false)
    private boolean ativo = true;
    @Column(nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();

    protected Produto() {}
    public Produto(String nome, String descricao, BigDecimal preco, Integer estoque) {
        this.nome = nome; this.descricao = descricao; this.preco = preco; this.estoque = estoque;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public BigDecimal getPreco() { return preco; }
    public Integer getEstoque() { return estoque; }
    public boolean isAtivo() { return ativo; }
    public Instant getCriadoEm() { return criadoEm; }
    public void atualizar(String nome, String descricao, BigDecimal preco, Integer estoque, boolean ativo) {
        this.nome = nome; this.descricao = descricao; this.preco = preco; this.estoque = estoque; this.ativo = ativo;
    }
    public void reduzirEstoque(int quantidade) {
        if (quantidade <= 0 || estoque < quantidade) throw new IllegalArgumentException("Estoque insuficiente.");
        estoque -= quantidade;
    }
}
