package com.nathan.bluemarket.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
    @UniqueConstraint(name = "uk_usuario_cpf", columnNames = "cpf"),
    @UniqueConstraint(name = "uk_usuario_email", columnNames = "email")
})
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 14)
    private String cpf;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false, length = 180)
    private String endereco;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Perfil perfil = Perfil.CLIENTE;
    @Column(nullable = false, updatable = false)
    private Instant criadoEm = Instant.now();

    protected Usuario() {}
    public Usuario(String nome, String cpf, String email, String senha, String endereco, Perfil perfil) {
        this.nome = nome; this.cpf = cpf; this.email = email; this.senha = senha;
        this.endereco = endereco; this.perfil = perfil == null ? Perfil.CLIENTE : perfil;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getEndereco() { return endereco; }
    public Perfil getPerfil() { return perfil; }
    public Instant getCriadoEm() { return criadoEm; }
    public void atualizarDados(String nome, String email, String endereco) {
        this.nome = nome; this.email = email; this.endereco = endereco;
    }
}
