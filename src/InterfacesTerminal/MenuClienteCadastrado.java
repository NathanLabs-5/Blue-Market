package InterfacesTerminal;

import Systema.Sistema;
import itens_e_pessoas.Conta;
import itens_e_pessoas.Pessoa;
import itens_e_pessoas.Produto;

import java.util.Scanner;

public class MenuClienteCadastrado {
    static void main() {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();

    }
    public static void MenuCDS(Scanner ler, Sistema sistema, Pessoa contalogada,Conta conta){
        int opcao;

        do{
            System.out.println("== BLUE MARKET ==\n1 - Ver saldo\n2 - Depositar saldo\n3 - Ver produtos\n4 - Adicionar ao carrinho\n5 - Ver carrinho\n6 - Finalizar compra\n7 - Ver histórico de pedidos\n8 - Sair");
            opcao = ler.nextInt();

            switch (opcao){
                case 1:
                    verSaldo(conta);
                    break;
                case 2:
                    depositar(conta,ler);
                    break;
                case 3:
                    produtos(sistema);
                    break;
                case 4:
                    addProdutoCarrin(ler,sistema,conta);
                    break;
                case 5:
                    mstraritens(ler, sistema);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("erro!opção inválida");
            }

        }while (opcao != 8);




    }public static void addProdutoCarrin(Scanner ler,Sistema sistema,Conta conta){
        ler.nextLine();

        System.out.println("informe o item que procura: ");
        String item = ler.nextLine();

        for(Produto p : sistema.getProdutos()){
            if (item.equalsIgnoreCase(p.getNome())){
                conta.adicionarAoCarrinho(p);

                System.out.println("item adicionado ao carrinho!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");


    }
    public static void mstraritens(Scanner ler,Sistema sistema) {

        System.out.println("== CARRINHO ==");
        System.out.println(sistema.getProdutos().toString());
        System.out.println("==============");

    }
    public static void verSaldo(Conta contalogada){
        System.out.println("\n=== SALDO ATUAL ===\n");
        System.out.println(contalogada.getSaldo());
    }
    public static void depositar(Conta conta,Scanner ler){
        System.out.println("\n=== DEPÓSITO ===\n");
        System.out.println("informe a quantia a ser adicionada: ");

        double addValor = ler.nextDouble();

        conta.depositar(addValor);
        System.out.println("=== DEPÓSITO CONCLUIDO ===");

    }
    public static void produtos(Sistema sistema){
        System.out.println("=== CARRINHO ===");
        System.out.println(sistema.getProdutos());

    }

}


