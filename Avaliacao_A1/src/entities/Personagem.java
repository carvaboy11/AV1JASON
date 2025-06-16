package entities;

public abstract class Personagem {
	protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int armor;
    protected int forca;
    protected int destreza;
	
    public Personagem(String nome, int vidaMaxima, int vidaAtual) {
		this.nome = nome;
		this.vidaMaxima = vidaMaxima;
		this.vidaAtual = vidaAtual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	public int getVidaAtual() {
		return vidaAtual;
	}

	public void setVidaAtual(int vidaAtual) {
		this.vidaAtual = vidaAtual;
	}
	
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public boolean estaVivo() {
        return vidaAtual > 0;
    }
	
	public void adicionarForca(int quantidade) {
		forca += quantidade;
	}
	
	public void adicionarDestreza(int quantidade) {
		forca += quantidade;
	}

	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n***" + nome + "***");
    	sb.append("\nVida maxima: " + vidaMaxima);
    	sb.append("\nVida atual: " + vidaAtual);
    	return sb.toString();
    }

    
    
}
