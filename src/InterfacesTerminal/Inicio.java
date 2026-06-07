package InterfacesTerminal;

import Systema.Sistema;

import java.util.Scanner;

public class Inicio {
    static void main() {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();
        iniciar(ler,sistema);

    }public static void iniciar(Scanner ler,Sistema sistema){

        int escoolha ;
        do {
            System.out.println("== Blue Market ==\n1-Área Cliente\n2-Área Funcionario\n3-Área Gerente\n4-Sair");
            escoolha = ler.nextInt();

            switch (escoolha){
                case 1:
                   MenuGhost.MenuGst(ler, sistema);
                   break;
//                case 2:
                case 3:
                    MenuGerente.menu(ler, sistema);
                    break;
                case 4:
                    break;

                default:
                    System.out.println("ERRO!opção inválida!");

            }

        }while (escoolha != 4);

    }

}
