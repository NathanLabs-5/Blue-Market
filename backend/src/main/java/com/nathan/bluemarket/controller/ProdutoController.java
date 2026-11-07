package com.nathan.bluemarket.controller;
import com.nathan.bluemarket.dto.*;
import com.nathan.bluemarket.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/produtos") @CrossOrigin(origins="http://localhost:5173")
public class ProdutoController {
 private final ProdutoService service; public ProdutoController(ProdutoService s){service=s;}
 @GetMapping public List<ProdutoResponse> listar(){return service.listar();}
 @GetMapping("/{id}") public ProdutoResponse buscar(@PathVariable Long id){return service.buscar(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public ProdutoResponse criar(@Valid @RequestBody ProdutoRequest r){return service.criar(r);}
 @PutMapping("/{id}") public ProdutoResponse atualizar(@PathVariable Long id,@Valid @RequestBody ProdutoRequest r){return service.atualizar(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void remover(@PathVariable Long id){service.remover(id);}
}
