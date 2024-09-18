package lab11.Ex1_Observer;

import java.util.ArrayList;

public class Produto{
    private static int nextCodigo = 0; // Este é o contador estático
    private int codigo;
    private String descricao;
    private double preco;
    private enum_produtos tipo;
    private Cliente cliente_at;
    private ArrayList<Observer> observers;
    private long tempoMaximoLeilao; // tempo máximo em milissegundos
    private long tempoInicioLeilao; // tempo em que o produto foi colocado em leilão

    public Produto(String descricao, double preco, long tempoMaximoLeilao) {
        this.codigo = nextCodigo; // Atribui o valor atual do contador ao código do produto
        nextCodigo++; // Incrementa o contador
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
        this.cliente_at = cliente_at;
        this.observers = new ArrayList<Observer>();
        this.tempoMaximoLeilao = tempoMaximoLeilao;
    }

    private void notificar(boolean licitacao, Cliente cliente){
        for(Observer observer : observers){
            if(observer != cliente){
                observer.update(this, licitacao);
            }
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco, Cliente cliente) {
        if(this.preco < preco){
            this.preco = preco;
            this.notificar(true, cliente);
        }
    }

    public enum_produtos getTipo() {
        return tipo;
    }

    public void setTipo(enum_produtos tipo){
        this.tipo = tipo;
        if(tipo == enum_produtos.leilao){
            this.tempoInicioLeilao = System.currentTimeMillis();
            iniciarTemporizador();
            this.notificar(false, null);
        }
    }

    public Cliente getCliente_at() {
        return cliente_at;
    }

    public void setCliente_at(Cliente cliente_at) {
        this.cliente_at = cliente_at;
    }

    public void addOb(Observer ob) {
        this.observers.add(ob);
    }

    public void verificarEstado(){
        if(this.tipo == enum_produtos.leilao && System.currentTimeMillis() - this.tempoInicioLeilao > this.tempoMaximoLeilao){
            if(this.cliente_at != null){
                this.setTipo(enum_produtos.vendido);
            } else {
                this.setTipo(enum_produtos.stock);
            }
        }
    }

    private void iniciarTemporizador(){
        new java.util.Timer().schedule( 
            new java.util.TimerTask() {
                @Override
                public void run() {
                    if(tipo == enum_produtos.leilao){
                        if(cliente_at != null){
                            setTipo(enum_produtos.vendido);
                        } else {
                            setTipo(enum_produtos.stock);
                        }
                    }
                }
            }, 
            tempoMaximoLeilao
        );
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", tipo=" + tipo
                + ", cliente_at=" + cliente_at + ", observers=" + observers + "]";
    }
    
}
