public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;
    protected String id;
    protected String descricao;
    public Produto(String nome,double preco){
        this.nome=nome;
        this.preco=preco;
        this.estoque=0;
    }
    public String getid(){
        return this.id;
    }
    public String getdescricao(){
        return this.descricao;
    }
    public String getNome(){
        return this.nome;
    }
    public double getPreco(){
        return this.preco;
    }
    public int getEstoque(){
        return this.estoque;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setpreco(double preco){
        this.preco=preco;
    }
    public void setestoque(int estoque){
        this.estoque=estoque;
    }
    void ExibirDetalhes(){
        System.out.println("Nome:"+this.nome);
        System.out.println("Preço:"+this.preco);
        System.out.println("Estoque:"+this.estoque);
    }
    public void adicionarEstoque(int quantidade){
        if(quantidade>0) this.estoque+=quantidade;
    }
}
