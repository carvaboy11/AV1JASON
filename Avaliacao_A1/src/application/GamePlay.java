package application;

import application.geradores.GerarCartas;
import application.geradores.GerarMonstros;
import application.geradores.GerarRelatorio;
import application.utility.Console;
import application.utility.MapaRPG;
import entities.personagens.Heroi;


public class GamePlay {

	public static void main(String[] args) {
		
		String comando = "s";
		Heroi heroi = new Heroi("Arthur", 100, 100, 3, 3);
		GerarCartas cartas = new GerarCartas();
		cartas.gerarCartas(heroi);
		GerarMonstros monstros = new GerarMonstros();
		monstros.gerarTodosMonstros();
		
		System.out.println("*****Kill the King (demo)*****");
		System.out.println("Tutorial: ");
		System.out.println("1 - Aperte F para se movimentar no mapa");
        System.out.println("2 - Força adiciona mais 1 de dano nos ataques");
        System.out.println("3 - Destreza adiciona mais 1 de armor nas defesas");
        System.out.println("4 - Basta escolher a carta no seu turno para usa-la, mas cuidado com a energia (aperte 0 para encerrar o turno)");
		MapaRPG.exibirMapa();
		do {
			System.out.println("\nDigite 'f' para andar para frente ou 'sair' para sair:");
            comando = Console.lerString();

            if (comando.equalsIgnoreCase("f")) {
                MapaRPG.moverFrente(heroi, monstros.monstrosNormais, monstros.monstrosElite, monstros.monstrosChefes);
                MapaRPG.exibirMapa();
            } else if (comando.equals("sair")) {
                System.out.println("Saindo do jogo...");
                break;
            } else {
                System.out.println("Comando inválido.");
            }
        
            if(heroi.estaVivo() == false) {
            	comando = "sair";
            }

			
		}while(comando != "sair");
		
		GerarRelatorio.gerar(heroi);
		
	}
	
}



