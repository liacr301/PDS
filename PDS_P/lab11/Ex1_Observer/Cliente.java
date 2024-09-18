package lab11.Ex1_Observer;

public class Cliente extends Observer {
    
    public Cliente(String nome) {
        super(nome);
    }

    public void update(Produto product, boolean licitacao) {
        if(licitacao){
            System.out.println("O cliente " + product.getCliente_at() + " licitou" + product.getPreco() + " euros" + "em"+ product);
        }
        else{
            enum_produtos estado=product.getTipo();
            if(estado==enum_produtos.stock){
                this.produtosleilao.remove(product);
                System.out.println("O produto " + product+ " nao recebeu qualquer tipo de licitação " );
            }
            if(estado==enum_produtos.leilao){
                System.out.println("O produto " + product+ " vai ser leiloado. O preço base é " + product.getPreco() + " euros" );
                this.produtosleilao.add(product);
            }
            if(estado==enum_produtos.vendido){
                this.produtosleilao.add(product);this.produtosleilao.remove(product);
                System.out.println("O produto " + product+ " foi vendido por " + product.getPreco() + " euros" );
            }
        }

    }

    public void licitacao(Produto product, double preco) {
        if (produtosleilao.contains(product) && product.getTipo() == enum_produtos.leilao) {
            if (preco > product.getPreco()) {
                product.setCliente_at(this);
                product.setPreco(preco, this);
            } else {
                System.out.println( this + " têm de licitar mais " + product.getPreco() + " € para continuar a licitar.");
            }
        } else {
            System.out.println(this + " o produto " + product.getDescricao() + " nao está disponível para licitações.");
        }
        System.out.println();
    }

    public void notify(Produto product){
        product.addOb(this);
        if(product.getTipo() == enum_produtos.leilao){
            this.produtosleilao.add(product);
        }
    }



}
