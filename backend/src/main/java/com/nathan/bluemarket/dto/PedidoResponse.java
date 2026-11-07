package com.nathan.bluemarket.dto;
import com.nathan.bluemarket.model.Pedido;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
public record PedidoResponse(Long id,Long clienteId,String clienteNome,BigDecimal total,String status,Instant criadoEm,List<ItemPedidoResponse> itens) {
 public static PedidoResponse from(Pedido p){return new PedidoResponse(p.getId(),p.getCliente().getId(),p.getCliente().getNome(),p.getTotal(),p.getStatus(),p.getCriadoEm(),p.getItens().stream().map(ItemPedidoResponse::from).toList());}
}
