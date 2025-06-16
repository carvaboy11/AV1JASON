package application.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Carta.Carta;
import entities.personagens.Heroi;
import entities.personagens.monstros.AcoesDoMonstro;
import entities.personagens.monstros.Monstro;
import exceptions.SemEnergiaException;

public class Combate {

	public static void combateSimples(Heroi heroi, Monstro monstro) {
	    heroi.getPilhaDeCompra().addAll(heroi.getCartasNoDeck());
	    Collections.shuffle(heroi.getPilhaDeCompra());

	    int turno = 1;
	    int turnoMonstroIndex = 0;

	    while (true) {
	        limparConsole();
	        System.out.println("\n=== TURNO " + turno + " ===");

	        heroi.setEnergiaAtual(heroi.getEnergia());

	        if (turno > 1) {
	            heroi.setArmor(0);
	            System.out.println("🛡️ Armadura do herói resetada para 0 no começo do turno.");
	        }

	        heroi.comprarCartas();

	        if (heroi.getPilhaDeCompra().isEmpty()) {
	            heroi.embaralharDeck();
	        }

	        int energiaHeroi = heroi.getEnergiaAtual();

	        exibirStatusECartas(heroi, monstro, turnoMonstroIndex);

	        ArrayList<Carta> mao = heroi.getMao();

	        while (!mao.isEmpty()) {
	            System.out.println("\n⚡ Energia restante: " + energiaHeroi);
	            System.out.print("Digite o número da carta que deseja usar (0 para passar): ");
	            int escolha = Console.lerInt();

	            if (escolha == 0) {
	                System.out.println("⏭️ Passando o turno do herói.");
	                break;
	            }

	            if (escolha < 1 || escolha > mao.size()) {
	                System.out.println("Número inválido. Tente novamente.");
	                continue;
	            }

	            Carta cartaEscolhida = mao.get(escolha - 1);

	            try {
	                if (cartaEscolhida.getEnergia() > energiaHeroi) {
	                    throw new SemEnergiaException("⚠️ Energia insuficiente para usar essa carta!");
	                }
	            } catch (SemEnergiaException e) {
	                System.out.println(e.getMessage());
	                continue;
	            }

	            System.out.println("🎴 Usando carta: " + cartaEscolhida.getNome());
	            heroi.usarCarta(cartaEscolhida);
	            energiaHeroi -= cartaEscolhida.getEnergia();
	            heroi.setEnergiaAtual(energiaHeroi);

	            if (cartaEscolhida instanceof entities.Carta.CartaDeDano) {
	                int danoBase = ((entities.Carta.CartaDeDano) cartaEscolhida).getDano();
	                int danoComBonus = danoBase + heroi.getForca();
	                monstro.receberDano(danoComBonus);
	                System.out.println("💥 Você causou " + danoComBonus + " de dano no monstro!");

	                if (!monstro.estaVivo()) {
	                    monstro.morrer();
	                    System.out.println("\n🏆 Você venceu o combate!");
	                    Recompensa.telaDeRecompensa(heroi);
	                    return;
	                }
	            } else if (cartaEscolhida instanceof entities.Carta.CartaDeDefesa) {
	                int armorBase = ((entities.Carta.CartaDeDefesa) cartaEscolhida).getDano();
	                heroi.receberArmor(armorBase);
	                System.out.println("🛡️ Seu herói ganhou +" + armorBase + " de Armor!");
	            }

	            try {
	                Thread.sleep(1500);
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }

	            limparConsole();
	            exibirStatusECartas(heroi, monstro, turnoMonstroIndex);

	            mao = heroi.getMao();
	        }

	        heroi.descartarMao();

	        System.out.println("\n>> TURNO DO MONSTRO");

	        AcoesDoMonstro acao = monstro.getTurno().get(turnoMonstroIndex);

	        String icone = switch (acao.getTipo().toLowerCase()) {
	            case "dano" -> "🗡️";
	            case "buff" -> "💪";
	            case "escudo" -> "🛡️";
	            case "cura" -> "💖";
	            default -> "❓";
	        };

	        System.out.println("🔮 O monstro se prepara para: " + icone + " " + acao.getTipo() + " (" + acao.getQuantidade() + ")");

	        switch (acao.getTipo().toLowerCase()) {
	            case "dano":
	                monstro.atacar(acao.getQuantidade(), heroi);

	                if (!heroi.estaVivo()) {
	                    System.out.println("\n💀 O herói foi derrotado!");	                   
	        	        heroi.setMortoPor(monstro.getNome());
	                    return;
	                }
	                break;
	            case "buff":
	                monstro.buffar(acao.getQuantidade());
	                break;
	            case "escudo":
	                monstro.receberArmor(acao.getQuantidade());
	                System.out.println(monstro.getNome() + " recebeu " + acao.getQuantidade() + " de armadura.");
	                break;
	            case "cura":
	                monstro.curar(acao.getQuantidade());
	                break;
	            default:
	                System.out.println(monstro.getNome() + " ficou confuso e não fez nada...");
	        }

	        try {
	            Thread.sleep(1500);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	        limparConsole();

	        turnoMonstroIndex++;
	        if (turnoMonstroIndex >= monstro.getTurno().size()) {
	            turnoMonstroIndex = 0;
	        }

	        System.out.println("\n--- STATUS FINAL DO TURNO ---");
	        System.out.println("🧝 Herói - Vida: " + heroi.getVidaAtual() + ", Armadura: " + heroi.getArmor());
	        System.out.println("👾 Monstro - Vida: " + monstro.getVidaAtual() + ", Armadura: " + monstro.getArmor());
	        
	        turno++;
	    }
	}




    private static void exibirStatusECartas(Heroi heroi, Monstro monstro, int turnoMonstroIndex) {
       
        System.out.printf("\n*** %s ***    -------------------------------    *** %s ***\n", heroi.getNome(), monstro.getNome());

        System.out.printf("🧝 Herói: (❤️ %d | 🛡️ %d | 💪 %d | 🎯 %d)    -------    👾 Monstro: (❤️ %d | 🛡️ %d | 💪 %d | 🎯 %d)\n",
                heroi.getVidaAtual(), heroi.getArmor(), heroi.getForca(), heroi.getDestreza(),
                monstro.getVidaAtual(), monstro.getArmor(), monstro.getForca(), monstro.getDestreza());

        List<AcoesDoMonstro> turno = monstro.getTurno();
        if (!turno.isEmpty()) {
            AcoesDoMonstro acao = turno.get(turnoMonstroIndex % turno.size());
            String icone = switch (acao.getTipo().toLowerCase()) {
                case "dano" -> "🗡️";
                case "escudo" -> "🛡️";
                case "buff" -> "💪";
                case "cura" -> "💖";
                default -> "❓";
            };
            System.out.println("🔮 O monstro se prepara para: " + icone + " " + acao.getTipo().toUpperCase() + " (" + acao.getQuantidade() + ")");
        }

        ArrayList<Carta> mao = heroi.getMao();
        System.out.println("\n🎴 Cartas na mão:");

        if (mao.isEmpty()) {
            System.out.println("🕳️ Nenhuma carta na mão.");
            return;
        }

        for (int i = 0; i < mao.size(); i++) {
            Carta c = mao.get(i);

            String icone = "";
            String detalhes = "";

            if (c instanceof entities.Carta.CartaDeDano) {
                icone = "🗡️";
                int danoBase = ((entities.Carta.CartaDeDano) c).getDano();
                int danoComBonus = danoBase + heroi.getForca();
                detalhes = "Dano: " + danoComBonus;
            } else if (c instanceof entities.Carta.CartaDeDefesa) {
                icone = "🛡️";
                int armorBase = ((entities.Carta.CartaDeDefesa) c).getDano();
                int armorComBonus = armorBase + heroi.getArmor();
                detalhes = "Armor: " + armorComBonus;
            } else {
                icone = "❓";
                detalhes = "Carta desconhecida";
            }

            String infoCarta = String.format("Carta %d: %s %s (⚡%d, %s)", i + 1, icone, c.getNome(), c.getEnergia(), detalhes);

            if (i % 2 == 0 && i != mao.size() - 1) {
                System.out.print(infoCarta + "   |   ");
            } else {
                System.out.println(infoCarta);
            }
        }
    }

    public static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
