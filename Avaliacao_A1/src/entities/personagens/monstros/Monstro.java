package entities.personagens.monstros;

import java.util.ArrayList;

import entities.Personagem;
import entities.TurnoPersonagem;
import entities.personagens.Heroi;

public class Monstro extends Personagem implements TurnoPersonagem{

	private ArrayList<AcoesDoMonstro> turno;

	public Monstro(String nome, int vidaMaxima, int vidaAtual) {
		super(nome, vidaMaxima, vidaAtual);
		this.turno = new ArrayList<>();
	}

	public ArrayList<AcoesDoMonstro> getTurno() {
		return turno;
	}

	public void addTurno(String tipo, int quantidade) {
	    turno.add(new AcoesDoMonstro(tipo, quantidade));
	}
	
	
	@Override
	public void atacar(int dano, Heroi heroi) {
		System.out.println(nome + " causa " + dano + " de dano ao " + heroi.getNome());
		heroi.receberDano((dano + forca));
	}
	
	@Override
	public void buffar(int buff) {
		System.out.println(nome + " se aprimorou!!");
		adicionarForca(buff);
	}
	
	@Override
	public void curar(int cura) {
		System.out.println(nome + " se curou em " + cura + " pv");	
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
	public void receberArmor(int escudo) {
		armor = armor + escudo + destreza;
	}
	
	@Override
	public void morrer() {
		System.out.println(nome + " foi derrotado!!");	
	}
	
}
