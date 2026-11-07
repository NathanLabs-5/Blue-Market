package com.nathan.bluemarket.service;
import com.nathan.bluemarket.dto.*;
import com.nathan.bluemarket.model.*;
import com.nathan.bluemarket.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
@Service
public class PedidoService {
 private final PedidoRepository pedidos; private final UsuarioRepository usuarios; private final ProdutoRepository produtos;
 public PedidoService(PedidoRepository p,UsuarioRepository u,ProdutoRepository pr){pedidos=p;usuarios=u;produtos=pr;}
 @Transactional public PedidoResponse finalizar(PedidoRequest r){
  Usuario cliente=usuarios.findById(r.clienteId()).orElseThrow(()->new RecursoNaoEncontradoException("Cliente não encontrado."));
  Pedido pedido=new Pedido(cliente); BigDecimal total=BigDecimal.ZERO;
  for(ItemCompraRequest item:r.itens()){
   Produto produto=produtos.findById(item.produtoId()).orElseThrow(()->new RecursoNaoEncontradoException("Produto "+item.produtoId()+" não encontrado."));
   if(!produto.isAtivo())throw new RegraNegocioException("Produto indisponível: "+produto.getNome());
   produto.reduzirEstoque(item.quantidade());
   pedido.adicionarItem(new ItemPedido(produto,item.quantidade(),produto.getPreco()));
   total=total.add(produto.getPreco().multiply(BigDecimal.valueOf(item.quantidade())));
  }
  pedido.definirTotal(total);return PedidoResponse.from(pedidos.save(pedido));
 }
 @Transactional(readOnly=true) public List<PedidoResponse> historico(Long id){
  if(!usuarios.existsById(id))throw new RecursoNaoEncontradoException("Cliente não encontrado.");
  return pedidos.findByClienteIdOrderByCriadoEmDesc(id).stream().map(PedidoResponse::from).toList();
 }
}
