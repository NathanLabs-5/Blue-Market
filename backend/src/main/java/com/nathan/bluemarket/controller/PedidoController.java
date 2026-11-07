package com.nathan.bluemarket.controller;
import com.nathan.bluemarket.dto.*;
import com.nathan.bluemarket.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/pedidos") @CrossOrigin(origins="http://localhost:5173")
public class PedidoController {
 private final PedidoService service; public PedidoController(PedidoService s){service=s;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public PedidoResponse finalizar(@Valid @RequestBody PedidoRequest r){return service.finalizar(r);}
 @GetMapping("/cliente/{clienteId}") public List<PedidoResponse> historico(@PathVariable Long clienteId){return service.historico(clienteId);}
}
