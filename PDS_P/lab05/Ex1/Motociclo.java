package lab05.Ex1;

public class Motociclo extends Veiculo {
	private String tipo;

	public Motociclo(String mat, String marca, String mod, int cc, String tipo) {
		super(mat, marca, mod, cc);
		this.tipo=tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if ((tipo == null || tipo.equals(""))||(!tipo.equals("desportivo") && !tipo.equals("estrada"))) throw new IllegalArgumentException("tipo invalido");
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Motociclo [tipo=" + this.getTipo() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + "]";
	}
}
