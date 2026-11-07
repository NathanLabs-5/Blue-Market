package com.nathan.bluemarket.dto;
import com.nathan.bluemarket.model.Usuario;
public record UsuarioResponse(Long id,String nome,String cpf,String email,String endereco,String perfil) {
 public static UsuarioResponse from(Usuario u){return new UsuarioResponse(u.getId(),u.getNome(),u.getCpf(),u.getEmail(),u.getEndereco(),u.getPerfil().name());}
}
