package application.utility;

import entities.personagens.Heroi;
import entities.personagens.monstros.Monstro;
import java.util.List;

public class MapaRPG {

    private static final String HEROI = "🧝";
    private static final String MONSTRO = "👾";
    private static final String ELITE = "👺";
    private static final String RECOMPENSA = "🎁";
    private static final String CHEFE = "🐉";
    private static int contadorMonstro = 0;
    private static int contadorElite = 0;
    private static int cartasAdquiridas = 9;
    private static boolean enfrentouChefe = false;
    private static boolean chefeDerrotado = false;
    
    private static String[] mapa = {
        HEROI, "--", MONSTRO, "--", MONSTRO, "--",
        ELITE, "--", RECOMPENSA, "--", MONSTRO, "--",
        ELITE, "--", MONSTRO, "--", RECOMPENSA, "--",
        ELITE, "--", MONSTRO, "--", RECOMPENSA, "--", CHEFE
    };
    
    private static int posicaoHeroi = 0;

    public static void exibirMapa() {
        for (String m : mapa) {
            System.out.print(m + " ");
        }
        System.out.println();
    }

    public static void moverFrente(Heroi heroi, List<Monstro> monstroNormal, List<Monstro> monstroElite, List<Monstro> chefe) {
        if (posicaoHeroi >= mapa.length - 1) {
            System.out.println("Voce derrotou o Rei Demonio!! Parabens!!");
            return;
        }

        mapa[posicaoHeroi] = "--";

        posicaoHeroi++;

        String evento = mapa[posicaoHeroi];

        if (evento.equals(MONSTRO) || evento.equals(ELITE) || evento.equals(RECOMPENSA) || evento.equals(CHEFE)) {
            System.out.println("Evento encontrado: " + evento);
            
            tratarEvento(evento, heroi, monstroNormal, monstroElite, chefe);

            mapa[posicaoHeroi] = "--";
        }

        mapa[posicaoHeroi] = HEROI;
    }

    private static void tratarEvento(String evento, Heroi heroi, List<Monstro> monstroNormal, List<Monstro> monstroElite, List<Monstro> chefe) {
        switch (evento) {
            case MONSTRO:
                System.out.println("Iniciando combate com Monstro!");
                Combate.combateSimples(heroi, monstroNormal.get(contadorMonstro));
                contadorMonstro++;
                cartasAdquiridas++;
                break;
            case ELITE:
                System.out.println("Iniciando combate com Elite!");
                Combate.combateSimples(heroi, monstroElite.get(contadorElite));
                contadorElite++;
                cartasAdquiridas++;
                break;
            case RECOMPENSA:
                System.out.println("Você encontrou uma recompensa!");
                Recompensa.recompensa(heroi);
                break;
            case CHEFE:
                System.out.println("Enfrentando o Chefe final!");
                Recompensa.recompensa(heroi);
                enfrentouChefe = true;
                chefeDerrotado = chefe.get(0).estaVivo();
                break;
            default:
                System.out.println("Evento desconhecido.");
                break;
        }
    }

	public static int getContadorMonstro() {
		return contadorMonstro;
	}

	public static int getContadorElite() {
		return contadorElite;
	}

	public static boolean getEnfrentouChefe() {
		return enfrentouChefe;
	}

	public static boolean getChefeDerrotado() {
		return chefeDerrotado;
	}

	public static int getCartasAdquiridas() {
		return cartasAdquiridas;
	}
	
	
    
    
}
