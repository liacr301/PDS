package lab11.Ex1_Observer;
import java.util.ArrayList;

public abstract class Observer {

    protected String nome;
    protected ArrayList<Produto> produtosleilao; 

    public void update(Produto product, boolean licitacao) {
        if(licitacao){
            System.out.println("O produto " + product.getDescricao() + " recebeu uma oferta mais alta de " + product.getPreco() + " €.");
        } else if(product.getTipo() == enum_produtos.vendido){
            System.out.println("A licitação para o produto " + product.getDescricao() + " terminou e foi vendido por " + product.getPreco() + " €.");
        }
    }

    public void notify(Produto product) {
        product.addOb(this);
    }

    public Observer(String nome) {
        this.nome = nome;
        this.produtosleilao = new ArrayList<Produto>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }

    
}
