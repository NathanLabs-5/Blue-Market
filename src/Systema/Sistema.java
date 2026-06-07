package Systema;

import InterfacesTerminal.MenuCadastrado;
import itens_e_pessoas.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Conta> contas;
    private ArrayList<Produto> produtos;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Gerente> gerentes;
    private static int contador;

    public Sistema(){
        this.contas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.gerentes = new ArrayList<>();

        Gerente admin = new Gerente("Admin","1233456789","Empresa");
        gerentes.add(admin);

    }
    public ArrayList<Conta> getCOntas(){
        return contas;

    }
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void cadastrarConta(Scanner ler, Sistema sistema) {
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

        Cliente user1 = new Cliente(nome, cpf, endereco);
        Conta C1 = new Conta(Sistema.contador, user1);

        sistema.getCOntas().add(C1);

        System.out.println("CONTA REGISTRADA COM SUCESSO!");


        Sistema.contador++;


    }public ArrayList<Conta> simnaoCadastro(Scanner ler,Sistema Sistema){


        System.out.println("Possui conta?\n[S/N]");
        String resposta = ler.nextLine();

        if (resposta.isEmpty()){
            System.out.println("ERRO!escolha uma opção");
        }

        if(resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")){
            for(Conta conta: contas){

                System.out.println("informe seu cpf: ");
                String cpf = ler.nextLine();


                if(conta.getCliente().getCpf().equalsIgnoreCase(cpf)){
                    MenuCadastrado.MenuCDS(ler,Sistema);

                }

            }
            return null;
        }
        if(resposta.equalsIgnoreCase("não") || resposta.equalsIgnoreCase("n") || resposta.equalsIgnoreCase("no") || resposta.equalsIgnoreCase("nao")){
            Sistema.cadastrarConta(ler, Sistema);

        }
        return null;

    }

}

