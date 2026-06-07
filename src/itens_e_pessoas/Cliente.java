package itens_e_pessoas;//script de poo:

public class Cliente extends Pessoa {

    private String nome;
    private String cpf;
    private String endereco;

    public Cliente(){
        super();

    }public Cliente(String nome, String cpf,String endereco){
        super(nome,cpf,endereco);
    //getters

    }public String getNome(){
        return nome;
    }public String getCpf(){
        return cpf;
    }public String getEndereco(){
        return endereco;

    }//setters:
    public void SetNome(String nome){
         this.nome = nome;

    }public void Setcpf(String cpf){
         this.cpf = cpf;

    }public String SetEndereco(String endereco){
        return this.endereco = endereco;
    }
    @Override
    public String toString(){
        return "|Nome: " + this.nome + " |cpf: " + this.cpf + " |endereco: " + this.endereco;
    }

}
