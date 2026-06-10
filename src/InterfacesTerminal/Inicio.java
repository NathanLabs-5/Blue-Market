package InterfacesTerminal;

import Systema.*;
import itens_e_pessoas.Cliente;
import itens_e_pessoas.Conta;
import itens_e_pessoas.Gerente;
import itens_e_pessoas.Pessoa;

import java.util.Scanner;

public class Inicio {
    static void main() {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();
        Sessao sessao = new Sessao();

        iniciar(ler, sistema, sessao);

    }

    public static void iniciar(Scanner ler, Sistema sistema, Sessao sessao) {

        while (true) {
            Pessoa contaLogada = sistema.loginOuCadastro(ler);

            int opcao;
            do {
                System.out.println("=== CONFIGURAÇÕES ===\n1-Entrar\n2-Criar Conta\n3-Sair");
                opcao = ler.nextInt();

                switch (opcao){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("ERRO!opção inválida!");
                }


            }while (opcao != 3);

            if (contaLogada == null) {
                MenuGhost.MenuGst(ler, sistema, contaLogada);

            }
            if (contaLogada != null) {
                if (contaLogada instanceof Gerente) {
                    MenuGerente.menu(ler, sistema,sessao);

                } else if (contaLogada instanceof Cliente) {

                    Conta conta = sistema.buscarConta(contaLogada.getCpf());
                    MenuClienteCadastrado.MenuCDS(ler, sistema, contaLogada,conta);
                }else {
                    System.out.println("ERRO");
                }
            }
        }


    }
}