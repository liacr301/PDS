package lab05.Ex1;

public class Automovel extends Veiculo {
	private String numquadro;

	public Automovel(String mat, String marca, String mod, int cc, String numquadro) {
		super(mat, marca, mod, cc);
		this.numquadro=numquadro;
	}

	public String getNumQuadro() {
		return numquadro;
	}

	public void setNumQuadro(String numquadro) {
		if (numquadro == null || numquadro.equals(""))
			throw new IllegalArgumentException("numero de quadro invalido");
		this.numquadro = numquadro;
	}
}
