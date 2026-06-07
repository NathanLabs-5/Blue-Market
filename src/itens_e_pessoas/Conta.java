package itens_e_pessoas;

public class Conta  {
    private int numero; //seria um id
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, Cliente cliente){
        this.numero = numero;
        this.cliente = cliente;
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
    @Override
    public String toString(){
        return "| Saldo: " + saldo +
                " | Numero: " + numero + cliente;

    }public Cliente getCliente(){
        return cliente;

    }public int getNumero(){
        return numero;

    }


}
