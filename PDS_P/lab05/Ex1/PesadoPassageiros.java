package lab05.Ex1;

public class PesadoPassageiros extends Pesado {
	private int passmax;

	public PesadoPassageiros(String mat, String marca, String mod, int cc, int peso, String numquadro, int passmax) {
		super(mat, marca, mod, cc, numquadro, peso);
		this.passmax=passmax;
	}

	public int getPassMax() {
		return passmax;
	}

	public void setPassMax(int passmax) {
		if (passmax <= 0)
			throw new IllegalArgumentException("numero maximo de passageiros invalido");
		this.passmax = passmax;
	}

	@Override
	public String toString() {
		return "PesadoPassageiros [passmax=" + this.getPassMax() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumQuadro() + "]";
	}
}
