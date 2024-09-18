package lab05.Ex1;

public class Taxi extends AutomovelLigeiro {
    private String numlicensa;

    public Taxi(String matricula, String marca, String modelo, int potencia, String numquadro, int capacidade_bagageira,String numlicensa) {
        super(matricula, marca, modelo, potencia, numquadro, capacidade_bagageira);
        this.numlicensa = numlicensa;
    }

    public String getNumeroLicensa() {
        return numlicensa;
    }

    public void setNumeroLicensa(String numlicensa) {
        if (numlicensa == null || numlicensa.equals(""))
            throw new IllegalArgumentException("numero de licensa invalido");
        this.numlicensa = numlicensa;
    }

    @Override
    public String toString() {
        return "Taxi [numero_licensa=" + this.getNumeroLicensa() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumQuadro() + ", capacidade_bagageira=" + this.getCapBagageira() + "]";
    }
}
