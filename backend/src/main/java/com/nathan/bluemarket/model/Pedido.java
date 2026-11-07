package com.nathan.bluemarket.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario cliente;
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total;
    @Column(nullable = false, length = 20)
    private String status = "CONFIRMADO";
    @Column(nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();

    protected Pedido() {}
    public Pedido(Usuario cliente) { this.cliente = cliente; this.total = BigDecimal.ZERO; }
    public void adicionarItem(ItemPedido item) { itens.add(item); item.definirPedido(this); }
    public void definirTotal(BigDecimal total) { this.total = total; }
    public Long getId() { return id; }
    public Usuario getCliente() { return cliente; }
    public BigDecimal getTotal() { return total; }
    public String getStatus() { return status; }
    public Instant getCriadoEm() { return criadoEm; }
    public List<ItemPedido> getItens() { return itens; }
}
