package com.nathan.bluemarket.controller;
import com.nathan.bluemarket.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(RecursoNaoEncontradoException.class) public ResponseEntity<?> notFound(RecursoNaoEncontradoException e){return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body(e.getMessage()));}
 @ExceptionHandler({RegraNegocioException.class,IllegalArgumentException.class}) public ResponseEntity<?> badRequest(RuntimeException e){return ResponseEntity.badRequest().body(body(e.getMessage()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<?> validation(MethodArgumentNotValidException e){
  String m=e.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).findFirst().orElse("Dados inválidos.");
  return ResponseEntity.badRequest().body(body(m));
 }
 private Map<String,Object> body(String m){return Map.of("timestamp",Instant.now(),"message",m);}
}
