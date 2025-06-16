package entities.personagens;

import java.util.ArrayList;
import java.util.Collections;

import entities.Personagem;
import entities.TurnoPersonagem;
import entities.Carta.Carta;

public class Heroi extends Personagem implements TurnoPersonagem{

    private ArrayList<Carta> cartasNoDeck = new ArrayList<>();
    private ArrayList<Carta> pilhaDeCompra = new ArrayList<>();
    private ArrayList<Carta> pilhaDeDescarte = new ArrayList<>(); 
    private ArrayList<Carta> mao = new ArrayList<>();
    private int energia;
    private int energiaAtual;
    private String mortoPor;

    public Heroi(String nome, int vidaMaxima, int vidaAtual, int energia, int energiaAtual) {
        super(nome, vidaMaxima, vidaAtual);
        this.energia = energia;
        this.energiaAtual = energiaAtual;
    }

    public ArrayList<Carta> getCartasNoDeck() {
        return cartasNoDeck;
    }

    public void addCarta(Carta c) {
        cartasNoDeck.add(c);
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public void setEnergiaAtual(int energiaAtual) {
        this.energiaAtual = energiaAtual;
    }

    public ArrayList<Carta> getPilhaDeCompra() {
        return pilhaDeCompra;
    }
    
    public void addPilhaDeCompra() {
    	
    	pilhaDeCompra.addAll(cartasNoDeck);
    	
    }

    public ArrayList<Carta> getPilhaDeDescarte() {
        return pilhaDeDescarte;
    }

    public ArrayList<Carta> getMao() {
        return mao;
    }
    
    public String getMortoPor() {
        return mortoPor;
    }

    public void setMortoPor(String mortoPor) {
        this.mortoPor = mortoPor;
    }

    public void embaralharDeck() {
        if (pilhaDeCompra.isEmpty()) {
            if (!pilhaDeDescarte.isEmpty()) {
                System.out.println("Embaralhando descarte para formar nova pilha de compra...");
                
                Collections.shuffle(pilhaDeDescarte);
                       
                pilhaDeCompra.addAll(pilhaDeDescarte);
                
                pilhaDeDescarte.clear();
            } else {
                System.out.println("Sem cartas para embaralhar!");
            }
        }
    }

    public void comprarCartas() {
        while (mao.size() < 5) {
            if (pilhaDeCompra.isEmpty()) {
                embaralharDeck();
                if (pilhaDeCompra.isEmpty()) { 
                    System.out.println("Não há mais cartas para comprar.");
                    break;
                }
            }
            mao.add(pilhaDeCompra.remove(0));
        }
    }

    public void usarCarta(Carta carta) {
        if (mao.contains(carta)) {
            mao.remove(carta);
            pilhaDeDescarte.add(carta);
            System.out.println("Carta usada: " + carta.getNome());
        } else {
            System.out.println("Carta não está na mão!");
        }
    }
    
    public void descartarMao() {
        pilhaDeDescarte.addAll(mao); 
        mao.clear();                 
    }
    
    public void adicionarEnergia(int energ) {
    	
    	energia += energ;
    	
    }
    
    @Override
    public void receberDano(int dano) {
        if (dano <= armor) {
            armor -= dano;
        } else if (dano > armor && armor != 0) {
            int resto = dano - armor;
            armor = 0;
            vidaAtual -= resto;
        } else if (armor == 0) {
            vidaAtual -= dano;
        }
    }
    
    @Override
    public void receberArmor(int defesa) {
    	
    	armor += defesa;
    	
    }
    
    @Override
	public void atacar(int dano, Heroi heroi) {
		System.out.println(nome + " causa " + dano + " de dano ao " + heroi.getNome());
		heroi.receberDano(dano + forca);
	}
    
    @Override
    public void buffar(int buff) {
    	forca += buff;
    	destreza += buff;
    }

    @Override
    public void curar(int cura) {
    	if(vidaAtual >= 80) {
    		vidaAtual = vidaMaxima;
    	}else if(vidaAtual <= 80) {
    		vidaAtual += 20;
    	}
    }
    
    @Override
    public void morrer() {
    	System.out.println("Voce foi derrotado e caiu no limbo dos mortos, seja esquecido pela eternidade");	
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nEnergia: " + energiaAtual + "/" + energia);
        return sb.toString();
    }
}
