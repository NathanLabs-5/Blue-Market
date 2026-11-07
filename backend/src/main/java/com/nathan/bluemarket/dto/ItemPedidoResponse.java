package com.nathan.bluemarket.dto;
import com.nathan.bluemarket.model.ItemPedido;
import java.math.BigDecimal;
public record ItemPedidoResponse(Long produtoId,String produtoNome,Integer quantidade,BigDecimal precoUnitario,BigDecimal subtotal) {
 public static ItemPedidoResponse from(ItemPedido i){return new ItemPedidoResponse(i.getProduto().getId(),i.getProduto().getNome(),i.getQuantidade(),i.getPrecoUnitario(),i.getPrecoUnitario().multiply(BigDecimal.valueOf(i.getQuantidade())));}
}
