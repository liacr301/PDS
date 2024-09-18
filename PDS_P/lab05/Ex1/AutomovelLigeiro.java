package lab05.Ex1;

public class AutomovelLigeiro extends Automovel {
	private int capbagageira;

	public AutomovelLigeiro(String mat, String marca, String mod, int cc, String numquadro, int capbagageira) {
		super(mat, marca, mod, cc, numquadro);
		this.capbagageira=capbagageira;
	}

	public int getCapBagageira() {
		return capbagageira;
	}

	public void setCapBagageira(int capbagageira) {
		if (capbagageira <= 0)
			throw new IllegalArgumentException("capacidade de bagageira invalida");
		this.capbagageira = capbagageira;
	}

	@Override
	public String toString() {
		return "AutomovelLigeiro [capbagageira=" + this.getCapBagageira() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumQuadro() + "]";
	}
}
