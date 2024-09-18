package lab05.Ex1;

public class PesadoMercadorias extends Pesado {
	int cargamax;

	public PesadoMercadorias(String mat, String marca, String mod, int cc, String numquadro, int peso, int cargamax) {
		super(mat, marca, mod, cc, numquadro, peso);
		this.cargamax=cargamax;
	}

	public int getCargaMax() {
		return cargamax;
	}

	public void setCargaMax(int cargamax) {
		if (cargamax <= 0)
			throw new IllegalArgumentException("carga maxima invalida");
		this.cargamax = cargamax;
	}

	@Override
	public String toString() {
		return "PesadoMercadorias [carga_maxima=" + this.getCargaMax() + ", matricula=" + this.getMatricula() + ", marca=" + this.getMarca() + ", modelo=" + this.getModelo() + ", potencia=" + this.getPotencia() + ", numero_do_quadro=" + this.getNumQuadro() + "]";
	}
}
