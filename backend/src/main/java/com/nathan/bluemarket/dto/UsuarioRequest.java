package com.nathan.bluemarket.dto;
import jakarta.validation.constraints.*;
public record UsuarioRequest(@NotBlank @Size(max=100) String nome,@NotBlank @Pattern(regexp="[0-9.\\-/]{11,14}",message="CPF inválido") String cpf,@NotBlank @Email @Size(max=150) String email,@NotBlank @Size(min=8,max=72) String senha,@NotBlank @Size(max=180) String endereco) {}
