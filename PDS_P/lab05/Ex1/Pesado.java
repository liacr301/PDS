package lab05.Ex1;

public class Pesado extends Automovel {
	private int peso;

	public Pesado(String mat, String marca, String mod, int cc, String numquadro, int peso) {
		super(mat, marca, mod, cc, numquadro);
		this.peso=peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		if (peso <= 0)
			throw new IllegalArgumentException("peso invalido");
		this.peso = peso;
	}
}
