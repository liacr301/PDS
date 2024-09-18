package lab05.Ex1;

public class Veiculo implements KmPercorridos {
	private String matricula, marca, modelo;
	private int potencia, kmstotal, kms_trajeto;
	
	public Veiculo(String mat, String marca, String mod, int cc) {
		this.matricula=mat; this.marca=marca; this.modelo=mod; this.potencia=cc;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	@Override
	public void trajeto(int quilometros) {
		kms_trajeto = quilometros;
		kmstotal+=quilometros;
	}

	@Override
	public int ultimoTrajeto() {
		return kms_trajeto;
	}

	@Override
	public int distanciaTotal() {
		return kmstotal;
	}

}
