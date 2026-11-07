package com.nathan.bluemarket.dto;
import com.nathan.bluemarket.model.Produto;
import java.math.BigDecimal;
public record ProdutoResponse(Long id,String nome,String descricao,BigDecimal preco,Integer estoque,boolean ativo) {
 public static ProdutoResponse from(Produto p){return new ProdutoResponse(p.getId(),p.getNome(),p.getDescricao(),p.getPreco(),p.getEstoque(),p.isAtivo());}
}
