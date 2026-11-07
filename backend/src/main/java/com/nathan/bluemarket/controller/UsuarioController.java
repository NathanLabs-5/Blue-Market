package com.nathan.bluemarket.controller;
import com.nathan.bluemarket.dto.*;
import com.nathan.bluemarket.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/usuarios") @CrossOrigin(origins="http://localhost:5173")
public class UsuarioController {
 private final UsuarioService service; public UsuarioController(UsuarioService s){service=s;}
 @PostMapping("/cadastro") @ResponseStatus(HttpStatus.CREATED) public UsuarioResponse cadastrar(@Valid @RequestBody UsuarioRequest r){return service.cadastrar(r);}
}
