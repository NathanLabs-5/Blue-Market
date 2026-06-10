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

                    break;
                case 3:

                    break;
                case 4:
                    addProduto(ler, sistema);
                    break;
                case 5:
                    mstraritens(ler, sistema);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("");
            }

        }while (opcao != 8);




    }public static void addProduto(Scanner ler,Sistema sistema){
        System.out.println("informe o item que procura: ");
        String item = ler.nextLine();

        if(item.isEmpty()){
            System.out.println("ERRO!\ninforme um valor.");
            return;
        }
        sistema.getProdutos().add(new Produto(item));
        System.out.println("item cadastrado com sucesso!");
    }
    public static void mstraritens(Scanner ler,Sistema sistema) {

        System.out.println("== PRODUTOS ==");
        System.out.println(sistema.getProdutos());
        System.out.println("==============");

    }
    public static void verSaldo(Conta contalogada){
        System.out.println("\n=== SALDO ATUAL ===\n");
        System.out.println(contalogada.getSaldo());
    }

}


