package entities;

import entities.personagens.Heroi;

public interface TurnoPersonagem {
	
	public void atacar(int dano, Heroi heroi);
	public void receberDano(int dano);
	public void receberArmor(int escudo);
	public void curar(int cura);
	public void buffar(int buff);
	public void morrer();
	
}
