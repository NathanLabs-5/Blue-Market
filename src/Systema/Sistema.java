package Systema;

import InterfacesTerminal.MenuClienteCadastrado;
import itens_e_pessoas.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Conta> contas;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Pessoa> pessoas;
    private static int contador;

    public Sistema(){
        this.contas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.pessoas = new ArrayList<>();

        Gerente admin = new Gerente("Admin","1233456789","Empresa");
        pessoas.add(admin);


    }
    public ArrayList<Conta> getCOntas(){
        return contas;

    }
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void cadastrarConta(Scanner ler) {
        ler.nextLine();
        System.out.println("== Cadastro ==\ninforme seu nome: ");
        String nome = ler.nextLine();

        if (nome.isEmpty()) {
            System.out.println("ERRO!\ninforme um valor.");
            return;
        }

        System.out.println("informe seu cpf: ");
        String cpf = ler.nextLine();

        if (cpf.isEmpty()) {
            System.out.println("ERRO!\ninforme um valor.");
            return;
        }

        System.out.println("informe seu endereço: ");
        String endereco = ler.nextLine();

        if (endereco.isEmpty()) {
            System.out.println("ERRO!\ninforme um valor.");
            return;
        }

        Pessoa user1 = new Cliente(nome, cpf, endereco);
        pessoas.add(user1);

        Conta C1 = new Conta(Sistema.contador, user1);
        contas.add(C1);

        System.out.println("CONTA REGISTRADA COM SUCESSO!");
        Sistema.contador++;




    }public Pessoa loginOuCadastro(Scanner ler) {
        System.out.println("Possui conta? [S/N]");
        String resp = ler.nextLine();

        if (resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("nao") || resp.equalsIgnoreCase("não")){
            cadastrarConta(ler);
            return null;

        }else if(resp.equalsIgnoreCase("s") || resp.equalsIgnoreCase("sim")){
            System.out.print("CPF: ");
            String cpf = ler.nextLine();

            System.out.println("Pessoas cadastradas:");
            for (Pessoa p : pessoas) {
                System.out.println(p.getNome() + " -> " + p.getCpf());
                if (p.getCpf().equals(cpf)) {
                    System.out.println("CPF digitado: " + cpf);
                    return p;
                }
            }

            System.out.println("Conta não encontrada!");
            return null;
        }else{
            System.out.println("ERRO!opção inválida");
        }
        return null;
    }
    public Conta buscarConta(String cpf){
        for(Conta c : contas){
            if(c.getPessoa().getCpf().equals(cpf)){
                return c;
            }
        }
        return null;

    }



}

