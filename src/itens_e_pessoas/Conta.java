package itens_e_pessoas;

public class Conta  {
    private int numero; //seria um id
    private double saldo;
    private Pessoa pessoa;

    public Conta(int numero,Pessoa pessoa){
        this.numero = numero;
        this.pessoa = pessoa;
        this.saldo = 0;

    }public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
        }else{
            System.out.println("ERRO!\nsomente valores válidos.");
        }


    }public void sacar(double valor) {

        if(valor <= 0){
            System.out.println("Saque indisponível!");

        }else if(valor <= saldo){
            saldo -= valor;
        }else{
            System.out.println("ERRO!\nsaque indisponível");
        }


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


}
