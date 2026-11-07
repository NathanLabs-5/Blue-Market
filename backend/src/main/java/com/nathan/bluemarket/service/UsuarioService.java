package com.nathan.bluemarket.service;
import com.nathan.bluemarket.dto.*;
import com.nathan.bluemarket.model.*;
import com.nathan.bluemarket.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class UsuarioService {
 private final UsuarioRepository repository; private final BCryptPasswordEncoder encoder;
 public UsuarioService(UsuarioRepository repository,BCryptPasswordEncoder encoder){this.repository=repository;this.encoder=encoder;}
 public UsuarioResponse cadastrar(UsuarioRequest r){
  if(repository.existsByEmail(r.email()))throw new RegraNegocioException("E-mail já cadastrado.");
  if(repository.existsByCpf(r.cpf()))throw new RegraNegocioException("CPF já cadastrado.");
  Usuario u=new Usuario(r.nome(),r.cpf(),r.email(),encoder.encode(r.senha()),r.endereco(),Perfil.CLIENTE);
  return UsuarioResponse.from(repository.save(u));
 }
}
