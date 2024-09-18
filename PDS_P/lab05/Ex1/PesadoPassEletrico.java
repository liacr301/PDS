package lab05.Ex1;

public class PesadoPassEletrico extends PesadoPassageiros implements VeiculoEletrico {
    private int autonomia_max, autonomia_restante;

    public PesadoPassEletrico(String matricula, String marca, String modelo, int potencia, int peso, String numquadro, int max_passageiros, int autonomia_restante,int autonomia_max) {
        super(matricula, marca, modelo, potencia, peso, numquadro, max_passageiros);
        this.autonomia_max = autonomia_max;
        this.autonomia_restante = autonomia_restante;
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
        return "PesadoPassEletrico [autonomia_max=" + this.getAutonomiaMax() + ", autonomia_restante=" + this.autonomia() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumQuadro() + ", peso=" + this.getPeso() + ", max_passageiros=" + this.getPassMax() + "]";
    }
}
