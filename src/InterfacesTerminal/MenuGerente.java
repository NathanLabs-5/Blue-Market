package InterfacesTerminal;

import Systema.Sessao;
import Systema.Sistema;
import itens_e_pessoas.Conta;
import itens_e_pessoas.Gerente;
import itens_e_pessoas.Produto;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Systema.Sistema.contadorItens;

public class MenuGerente {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Sistema sistema = new Sistema();

    }public static void menu(Scanner ler, Sistema sistema,Sessao sessao){
        int opcao;
        do{
            System.out.println("== Menu ==\n1-verificar conta\n2-verificar cliente\n3-Recuperar conta pelo indíce\n4-verificar se cliente possui conta\n5-Remover Conta\n6-Adicionar Produtos ao estoque\n7-Sair");
            opcao = ler.nextInt();
            ler.nextLine();

                switch (opcao){
                    case 1:
                        verificarConta(ler,sistema);
                        break;
                    case 2:
                        verificarCliente(ler,sistema);
                        break;
                    case 3:
                        recuperarIndice(ler,sistema);
                        break;
                    case 4:
                        verificarClienteConta(ler,sistema);
                        break;
                    case 5:
                        ExcluirConta(ler, sistema, sessao);
                        break;
                    case 6:
                        addProd(ler, sistema);
                        break;
                    case 7:
                        sessao.sairConta();
                        return;
                    default:
                        System.out.println("ERRO!\nopção inválida!");
                }
        }while (opcao != 6);

    }private static Conta verificarCliente(Scanner ler, Sistema sistema){

        System.out.println("informe seu cpf: ");
        String cpf = ler.nextLine();

        if(cpf.isEmpty()){
            System.out.println("ERRO!\ninforme um valor.");
        }

        for (Conta conta: sistema.getCOntas()){
            if (conta.getPessoa().getCpf().equalsIgnoreCase(cpf)){
                System.out.println("CPF VÁLIDO!\n" + conta );

                return conta;
            }
        }
        System.out.println("ERRO!\nCPF INVÁLIDO!");
        return null; //valor necessario caso n achar nada pra n dar erro dps q terminar o for

    }public static Conta verificarConta(Scanner ler,Sistema sistema){//passei o obj pra retonar metodos

        System.out.println("informe o numero da sua conta: ");
        int numero = ler.nextInt();

        for(Conta conta: sistema.getCOntas()){
            if(conta.getNumero() == numero){
                System.out.println("ACESSADO COM SUCESSO!\n" + conta);
                return conta;
            }
        }
        System.out.println("ERRO!\nCPF INVÁLIDO!");
        return null;

    }private static void verificarClienteConta(Scanner ler,Sistema sistema){
        System.out.println("informe o seu cpf: ");
        String cpf = ler.nextLine();

        for(Conta conta: sistema.getCOntas()){
            if(conta.getPessoa().getCpf().equalsIgnoreCase(cpf)){
                System.out.println("Usuario encontrado\nBem-vindo: " + conta.getPessoa().getNome());

                System.out.println("informe o numero da sua conta: ");
                int numero = ler.nextInt();


                if(conta.getNumero() == numero){
                    System.out.println("Acesso Concluído!\n" + conta);
                }else{
                    System.out.println("ERRO!\nConta inoperante!");
                    return;
                }
            }
        }
        System.out.println("ERRO!\n CPF inválido!");

    }private static void recuperarIndice(Scanner ler,Sistema sistema) {
        System.out.println("informe o numero da conta que procura: ");
        int indice;

        try {
            indice = ler.nextInt();

            for (Conta conta : sistema.getCOntas()) {
                if (conta.getNumero() == indice) {
                    System.out.println(conta);
                    return;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("ERRO!somente numeros");
            ler.nextLine();
        }
        System.out.println("ERRO!\nitens_e_pessoas.Conta não encontrada! informe um indice válido.");


    }
    public static void ExcluirConta(Scanner ler,Sistema sistema,Sessao sessao){
        System.out.println("informe o cpf da conta que deseja excluir: ");
        String cpf = ler.nextLine();

        Conta conta = sistema.buscarConta(cpf);

        if(conta != null){
            if(sessao.getContaLogada()==conta){
                sessao.setContaLogada(null);
            }

            sistema.removerconta(cpf);
            System.out.println("Conta removida com sucesso!");

        }else{
            System.out.println("Conta não encontrada.");
        }
    }
    public static void addProd(Scanner ler, Sistema sistema){
        System.out.println("informe o nome do produto: ");
        String item = ler.nextLine();

        if(item.isEmpty()){
            System.out.println("ERRO!\ninforme um valor.");
            return;
        }
        System.out.println("informe o preço do produto: ");
        double preco = ler.nextDouble();

        sistema.getProdutos().add(new Produto(item,preco,contadorItens));
        System.out.println("item cadastrado com sucesso!");

    }
}