package application.geradores;

import java.util.ArrayList;
import java.util.Random;

import entities.Carta.Carta;
import entities.Carta.CartaDeDano;
import entities.Carta.CartaDeDefesa;
import entities.personagens.Heroi;

public class GerarCartas {

    public void gerarCartas(Heroi heroi) {

        for (int i = 0; i < 5; i++) {
            CartaDeDano ataque = new CartaDeDano("Golpe", 1, 6);
            CartaDeDefesa defesa = new CartaDeDefesa("Escudo", 1, 5);
            heroi.addCarta(ataque);
            heroi.addCarta(defesa);
        }
    }
    
    public ArrayList<Carta> gerarCartas() {
        ArrayList<Carta> cartas = new ArrayList<>();

        cartas.add(new CartaDeDano("Golpe Fraco", 0, 3));       
        cartas.add(new CartaDeDano("Ataque Rápido", 1, 10));    
        cartas.add(new CartaDeDano("Golpe Forte", 2, 25));     
        cartas.add(new CartaDeDano("Investida", 3, 35));       
        cartas.add(new CartaDeDano("Corte Preciso", 1, 15));    
        cartas.add(new CartaDeDano("Impacto Poderoso", 3, 40)); 

        cartas.add(new CartaDeDefesa("Bloqueio Leve", 0, 4));       
        cartas.add(new CartaDeDefesa("Parada Rápida", 1, 12));     
        cartas.add(new CartaDeDefesa("Escudo Sólido", 2, 28));      
        cartas.add(new CartaDeDefesa("Barreira Forte", 3, 38));     
        cartas.add(new CartaDeDefesa("Postura Defensiva", 1, 14)); 
        cartas.add(new CartaDeDefesa("Guardião", 3, 40));           

        return cartas;
    }
}
