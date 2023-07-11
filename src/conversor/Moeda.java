package conversor;

public class Moeda {
	
	private String nome;
	private String simbolo;
	private double taxaCambio;

	public Moeda(String nome, String simbolo, double taxaCambio) {
		this.nome = nome;
		this.simbolo = simbolo;
		this.taxaCambio = taxaCambio;
	}

	public String getNome() {
		return nome;
	}
	
	public String getSimbolo() {
		return simbolo;
	}

	public double getTaxaCambio() {
		return taxaCambio;
	}

	@Override
	public String toString() {
		return nome;
	}

}
