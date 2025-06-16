package application.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.geradores.GerarCartas;
import entities.Carta.Carta;
import entities.personagens.Heroi;

public class Recompensa {

    private static ArrayList<Carta> todasCartas = new ArrayList<>();
    private static List<Carta> cartasDisponiveis = new ArrayList<>();

    public static void inicializarCartas() {
        if (todasCartas.isEmpty()) {
            todasCartas = new GerarCartas().gerarCartas();
            cartasDisponiveis = new ArrayList<>(todasCartas);
        }
    }

    public static void telaDeRecompensa(Heroi heroi) {
        Scanner sc = new Scanner(System.in);

        if (todasCartas.isEmpty()) {
            inicializarCartas();
        }

        if (cartasDisponiveis.isEmpty()) {
            System.out.println("Nenhuma carta disponível para recompensa.");
            return;
        }

        System.out.println("\nEscolha uma carta entre as opções abaixo:");

        List<Carta> opcoes = new ArrayList<>();
        int maxOpcoes = Math.min(3, cartasDisponiveis.size());
        for (int i = 0; i < maxOpcoes; i++) {
            Carta c = cartasDisponiveis.get(i);
            opcoes.add(c);
            System.out.println((i + 1) + ") " + c.toString());
        }

        int escolha = 0;
        do {
            System.out.print("Digite o número da carta que deseja escolher: ");
            if (sc.hasNextInt()) {
                escolha = sc.nextInt();
            } else {
                sc.next();
                escolha = 0;
            }
        } while (escolha < 1 || escolha > maxOpcoes);

        Carta cartaEscolhida = opcoes.get(escolha - 1);

        heroi.addCarta(cartaEscolhida);

        System.out.println("Você escolheu a carta: " + cartaEscolhida.getNome());

        cartasDisponiveis.remove(cartaEscolhida);
    }
    
    public static void recompensa(Heroi heroi) {
    	int op;
    	
    	System.out.println("Escolha apenas um!!");
    	System.out.println("Opção 1: +1 de força (adiciona mais 1 de dano em cada carta) +1 de destreza (ganha mais 1 de armor em cada carta)");
    	System.out.println("Opção 2: Cure 20 de vida (vida atual: " + heroi.getVidaAtual() + "PV)");
    	System.out.println("Opção 3: Ganhe mais 1 de energia em todo turno");
    	op = Console.lerInt();
    	
    	switch (op) {
    	
    	case 1: 
    		heroi.adicionarForca(1);
    		heroi.adicionarDestreza(1);
    		System.out.println(heroi.getNome() + " foi aprimorado!!");
    		break;
    	
    	case 2:
    		heroi.curar(20);
    		System.out.println(heroi.getNome() + " foi curado!! (vida atual: " + heroi.getVidaAtual() + "PV)");
    		break;
    		
    	case 3: 
    		heroi.adicionarEnergia(1);
    		System.out.println(heroi.getNome() + " tem mais energia em cada combate!!");
    		break;
    		
    	default: 
    		System.out.println("Escolha errada... Não ganhou nada...");
    		break; 
    	}
    	
    }
}
