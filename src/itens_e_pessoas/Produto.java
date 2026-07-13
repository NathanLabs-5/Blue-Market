package itens_e_pessoas;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;


    public Produto(String nome,double preco, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }


    public String getNome() {
        return nome;
    }
    public void setItem(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "|Nome: " + nome + "\n" + "|preço: " + preco + "\n" + "|estoque: " + estoque;
    }
}
