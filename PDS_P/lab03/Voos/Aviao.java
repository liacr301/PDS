package lab03.Voos;

public class Aviao {
    private int ex_linhas;
    private int ex_colunas;
    private int t_linhas;
    private int t_colunas;
    
    public Aviao(int ex_linhas, int ex_colunas, int t_linhas, int t_colunas) {
        this.ex_linhas = ex_linhas;
        this.ex_colunas = ex_colunas;
        this.t_linhas = t_linhas;
        this.t_colunas = t_colunas;
    }

    public Aviao(int t_linhas, int t_colunas) {
        this.t_linhas = t_linhas;
        this.t_colunas = t_colunas;
    }

    public int getLugaresTuristica() {
        return this.t_linhas * this.t_colunas;
    }

    public int getLugaresExecutiva() {
        return this.ex_linhas * this.ex_colunas;
    }


    public int getExLinhas() {
        return this.ex_linhas;
    }

    public int getExColunas() {
        return this.ex_colunas;
    }

    public int getTuLinhas() {
        return this.t_linhas;
    }

    public int getTuColunas() {
        return this.t_colunas;
    }


    @Override
    public String toString() {
        return "Plane : {" +
            " ex_linhas='" + this.getExLinhas() + "'" +
            ", ex_colunas='" + this.getExColunas() + "'" +
            ", t_linhas='" + this.getTuLinhas() + "'" +
            ", t_colunas='" + this.getTuColunas() + "'" +
            "}";
    }

}
