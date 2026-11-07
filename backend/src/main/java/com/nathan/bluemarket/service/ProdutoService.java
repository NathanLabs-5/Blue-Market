package com.nathan.bluemarket.service;
import com.nathan.bluemarket.dto.*;
import com.nathan.bluemarket.model.Produto;
import com.nathan.bluemarket.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service @Transactional
public class ProdutoService {
 private final ProdutoRepository repository;
 public ProdutoService(ProdutoRepository repository){this.repository=repository;}
 @Transactional(readOnly=true) public List<ProdutoResponse> listar(){return repository.findByAtivoTrue().stream().map(ProdutoResponse::from).toList();}
 @Transactional(readOnly=true) public ProdutoResponse buscar(Long id){return ProdutoResponse.from(repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Produto não encontrado.")));}
 public ProdutoResponse criar(ProdutoRequest r){return ProdutoResponse.from(repository.save(new Produto(r.nome(),r.descricao(),r.preco(),r.estoque())));}
 public ProdutoResponse atualizar(Long id,ProdutoRequest r){Produto p=repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Produto não encontrado."));p.atualizar(r.nome(),r.descricao(),r.preco(),r.estoque(),true);return ProdutoResponse.from(p);}
 public void remover(Long id){Produto p=repository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Produto não encontrado."));p.atualizar(p.getNome(),p.getDescricao(),p.getPreco(),p.getEstoque(),false);}
}
