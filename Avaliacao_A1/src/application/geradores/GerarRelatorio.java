package application.geradores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import application.utility.MapaRPG;
import entities.personagens.Heroi;

public class GerarRelatorio {

    public static void gerar(Heroi heroi) {

        File diretorio = new File("relatorios");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String caminhoArquivo = "relatorios/relatorio_da_jornada_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("===== RELATÓRIO DA JORNADA =====\n\n");
            writer.write("Data/Hora: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n\n");

            writer.write("🧝 Nome do Herói: " + heroi.getNome() + "\n");
            writer.write("❤️ Vida Restante: " + heroi.getVidaAtual() + "\n");
            writer.write("💪 Força: " + heroi.getForca() + "\n");
            writer.write("🎯 Destreza: " + heroi.getDestreza() + "\n\n");

            if (!heroi.estaVivo()) {
                writer.write("💀 Morreu para: " + heroi.getMortoPor() + "\n\n");
            }

            writer.write("⚔️ Inimigos enfrentados:\n");
            writer.write(" - Monstros comuns: " + MapaRPG.getContadorMonstro() + "\n");
            writer.write(" - Elites: " + MapaRPG.getContadorElite() + "\n\n");

            writer.write("🎴 Cartas adquiridas: " + MapaRPG.getCartasAdquiridas() + "\n\n");

            writer.write("🐉 Chefe final enfrentado? " + (MapaRPG.getEnfrentouChefe() ? "Sim" : "Não") + "\n");
            writer.write("🏆 Chefe foi derrotado? " + (MapaRPG.getChefeDerrotado() ? "Sim" : "Não") + "\n\n");

            writer.write("===== FIM DA JORNADA =====\n");

            System.out.println("\n📄 Relatório da jornada salvo como: " + caminhoArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao gerar relatório: " + e.getMessage());
        }
    }
}
