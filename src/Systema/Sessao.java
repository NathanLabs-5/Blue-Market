package Systema;

import itens_e_pessoas.Conta;


public class Sessao {
    private Conta contaLogada;


    public Sessao(Conta contaLogada){
        this.contaLogada = contaLogada;

    }

    public Sessao() {

    }

    public Conta getContaLogada() {
        return contaLogada;

    }

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }

    public boolean entrarConta(){
        return contaLogada != null;

    }
    public boolean sairConta(){
        return this.contaLogada == null;
    }

}

