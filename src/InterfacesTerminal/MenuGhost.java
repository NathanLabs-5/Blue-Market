package InterfacesTerminal;



import Systema.Sistema;
import itens_e_pessoas.Pessoa;
import itens_e_pessoas.Produto;

import java.util.Scanner;

//obs: o visitante n pode: comprar,receber notificações, salvar no carrinho!


public class MenuGhost {
    static void main() {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();

    }

    public static void MenuGst(Scanner ler, Sistema sistema, Pessoa contaLogada) {
        int opcao;

        do {
            System.out.println("== BLUE MARKET ==\n1-carrinho\n2-buscar produtos\n3-Criar Conta)\n4-Sair");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    mstrarItens(ler, sistema);
                    break;
                case 2:
                    addProduto(ler, sistema);
                    break;

                case 3:
                    sistema.cadastrarConta(ler);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
            }

        } while (opcao != 4);


    }

    public static void addProduto(Scanner ler, Sistema sistema) {
        ler.nextLine();
        System.out.println("informe o item que procura: ");
        String item = ler.nextLine();

        if (item.isEmpty()) {
            System.out.println("ERRO!\ninforme um valor.");
            return;
        }
        sistema.getProdutos().add(new Produto(item));
        System.out.println("item cadastrado com sucesso!");
    }

    public static void mstrarItens(Scanner ler, Sistema sistema) {

        System.out.println("== PRODUTOS ==");
        System.out.println(sistema.getProdutos());
        System.out.println("==============");


    }
}

