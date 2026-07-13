package itens_e_pessoas;

import java.util.ArrayList;

public class Conta  {
    private int numero; //seria um id
    private double saldo;
    private Pessoa pessoa;
    ArrayList<Produto> carrinho;

    public Conta(int numero,Pessoa pessoa){
        this.numero = numero;
        this.pessoa = pessoa;
        this.saldo = 0;
        this.carrinho = new ArrayList<>();

    }public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
        }else{
            System.out.println("ERRO!\nsomente valores válidos.");
        }


    }public double sacar(double valor) {

        if(valor <= 0){
            System.out.println("Saque indisponível!");

        }else if(valor <= saldo){
            saldo -= valor;
        }else{
            System.out.println("ERRO!\nsaque indisponível");
        }


        return valor;
    }public double getSaldo(){
        return saldo;

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString(){
        return "| Saldo: " + saldo +
                " | Numero: " + numero + pessoa;



    }public int getNumero(){
        return numero;

    }

    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }
    public void adicionarAoCarrinho(Produto produto){
        carrinho.add(produto);
    }

}
