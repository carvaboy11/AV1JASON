package entities.Carta;

public class CartaDeDefesa extends Carta{
	
	private int defesa;
	private String tipo = "Tecnica";

	public CartaDeDefesa(String nome, int energia, int defesa) {
		super(nome, energia);
		this.defesa = defesa;
	}

	public int getDano() {
		return defesa;
	}

	public void setDano(int dano) {
		this.defesa = dano;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + tipo);
		sb.append(super.toString());
		sb.append("\nDefesa: " + defesa);
		return sb.toString();
	}

}
