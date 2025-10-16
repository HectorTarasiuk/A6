public class Produto {
    protected String nome;
    protected double preco;
    protected int estoque;
    protected String id;
    protected String descricao;
    public Produto(String nome,double preco,int estoque,String id,String descricao){
        this.nome=nome;
        this.preco=preco;
        this.estoque=0;
        this.id=id;
        this.descricao=descricao;
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
    void ExibirDetalhes(){
        System.out.println("Nome:"+this.nome);
        System.out.println("Preço:"+this.preco);
        System.out.println("Estoque:"+this.estoque);
        System.out.println("Id:"+this.id);
        System.out.println("Descriçcao:"+this.descricao);
    }
    public void adicionarEstoque(int quantidade){
        if(quantidade>0) this.estoque+=quantidade;
    }
}
