package entities.Carta;

public abstract class Carta {

	private String nome;
	private int energia;
	
	public Carta(String nome, int energia) {
		this.nome = nome;
		this.energia = energia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("***" + nome + "***");
		sb.append("\nCusto: " + energia);
		return sb.toString();
	}


	
	
	
}
