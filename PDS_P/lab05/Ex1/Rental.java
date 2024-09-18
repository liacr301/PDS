package lab05.Ex1;

import java.util.ArrayList;
import java.util.List;

public class Rental {
	private List<Veiculo> veiculos = new ArrayList<>();
	private String nome;
	private String codpostal;
	private String email;

	public Rental(String nome, String codpostal, String email) {
		this.nome=nome; this.codpostal=codpostal; this.email=email;
	}

	public String getNome() {
		return nome;
	}

	public String getCodPostal() {
		return codpostal;
	}

	public String getEmail() {
		return email;
	}
	
	public void addVeiculo(Veiculo v) {
		veiculos.add(v);
	}

	public void removeVeiculo(Veiculo v) {
		veiculos.remove(v);
	}
	
	public Veiculo getVeiculo(String matricula) {
		for (Veiculo v : veiculos) {
			if(v.getMatricula() == matricula) {
				return v;
			}
		}
		return null;
	}

	public List<Veiculo> getStock() {
		return veiculos;
	}

	public void setNome(String nome) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("nome invalido");
		this.nome = nome;
	}

	public void setCodPostal(String codpostal) {
		if (codpostal == null || codpostal.equals(""))
			throw new IllegalArgumentException("codigo postal invalido");
		this.codpostal = codpostal;
	}

	public void setEmail(String email) {
		if ((email == null || email.equals(""))||(!email.contains("@")))
			throw new IllegalArgumentException("email invalido");
		this.email = email;
	}
}
