package InterfacesTerminal;

import Systema.Sistema;
import itens_e_pessoas.Produto;

import java.util.Scanner;

public class MenuCadastrado {
    static void main() {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();

        MenuCDS(ler,sistema);
    }
    public static void MenuCDS(Scanner ler, Sistema sistema){
        int opcao;

        do{
            System.out.println("== BLUE MARKET ==\n1-carrinho\n2-buscar produtos\n5-Sair");
            opcao = ler.nextInt();

            switch (opcao){
                case 1:
                    mstraritens(ler, sistema);
                    break;
                case 2:
                    addProduto(ler, sistema);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("");
            }

        }while (opcao != 3);




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
}

