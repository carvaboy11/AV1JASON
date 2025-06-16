package entities.Carta;

public class CartaDeDano extends Carta{

	private int dano;
	private String tipo = "Ataque";

	public CartaDeDano(String nome, int energia, int dano) {
		super(nome, energia);
		this.dano = dano;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + tipo);
		sb.append(super.toString());
		sb.append("\nDano: " + dano);
		return sb.toString();
	}
	
}
