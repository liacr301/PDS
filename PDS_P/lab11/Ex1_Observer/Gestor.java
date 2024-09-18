package lab11.Ex1_Observer;

import java.util.ArrayList;

public class Gestor extends Observer{
    private ArrayList<Produto> produtosIn;
    private ArrayList<Produto> produtosOut;

    public Gestor(String nome) {
        super(nome);
        this.produtosIn = new ArrayList<Produto>();
        this.produtosOut = new ArrayList<Produto>();
    }

    public void atualizarEnum(Produto product, enum_produtos tipo){
        if(tipo == enum_produtos.vendido && product.getCliente_at() == null){
            System.out.println("O produto " + product.getDescricao() + " não pode ser vendido porque não recebeu uma licitação válida.");
        } else {
            product.setTipo(tipo);
            if(tipo == enum_produtos.vendido){
                System.out.println("O produto " + product.getDescricao() + " foi vendido para " + product.getCliente_at().getNome());
            } else {
                System.out.println("O produto " + product.getDescricao() + " foi atualizado para " + tipo);
            }
        }
    }

    public void update(Produto product, boolean licitacao) {
        if(licitacao){
            System.out.println("O produto " + product.getDescricao() + " foi licitado por " + product.getPreco() + " euros" + "a"+ product.getCliente_at());
        }
        else{
            enum_produtos estado=product.getTipo();
            if(estado==enum_produtos.stock){
                this.produtosleilao.remove(product);
                this.produtosIn.add(product);
                System.out.println("O produto " + product.getDescricao() + " foi vendido por " + product.getPreco() + " euros" + "a"+ product.getCliente_at());
            }
            if(estado==enum_produtos.leilao){
                this.produtosIn.remove(product);
                this.produtosleilao.add(product);

            }
            if(estado==enum_produtos.vendido){
                this.produtosleilao.remove(product);
                this.produtosOut.add(product);this.produtosIn.remove(product);
                System.out.println("E o item " + product + " foi vendido a" + product.getCliente_at() + " por " + String.valueOf(product.getPreco()) + "€.");
            }
        }

    }
}
