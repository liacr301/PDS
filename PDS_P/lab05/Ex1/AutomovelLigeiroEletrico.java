package lab05.Ex1;

public class AutomovelLigeiroEletrico extends AutomovelLigeiro implements VeiculoEletrico{
    private int autonomia_max, autonomia_restante;

    public AutomovelLigeiroEletrico(String matricula, String marca, String modelo, int potencia, String numquadro, int capbagageira, int autonomia_restante,int autonomia_max) {
        super(matricula, marca, modelo, potencia, numquadro, capbagageira);
        this.autonomia_max = autonomia_max;
        this.autonomia_restante = autonomia_max;
    }

    public int getAutonomiaMax() {
        return this.autonomia_max;
    }

    public int autonomia() {
        return this.autonomia_restante;
    }

    private void setAutonomiaRestante(int autonomia) {
        this.autonomia_restante = autonomia;
    }

    public void carregar(int percentagem) {
        if (percentagem < 0 || percentagem > 100) throw new IllegalArgumentException("percentagem invalida");
        this.setAutonomiaRestante(this.autonomia_max * percentagem / 100);
    }

    private void descarregar(int autonomia) {
        if (autonomia < 0) throw new IllegalArgumentException("autonomia invalida");
        this.setAutonomiaRestante(this.autonomia_restante - autonomia);
    }

    @Override
    public void trajeto(int quilometros) {
        if (quilometros <= 0) throw new IllegalArgumentException("quilometros invalidos");
        super.trajeto(quilometros);
        this.descarregar(quilometros);
    }

    @Override
    public String toString() {
        return "AutomovelLigeiroEletrico [autonomia_max=" + this.getAutonomiaMax() + ", autonomia_restante=" + this.autonomia() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumQuadro() + ", capacidade_bagageira=" + this.getCapBagageira() + "]";
    }
}
