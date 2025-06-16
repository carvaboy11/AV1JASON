package entities.personagens.monstros;

public class AcoesDoMonstro {

	private String tipo;
	private int quantidade;
	
	public AcoesDoMonstro(String tipo, int quantidade) {
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
}
