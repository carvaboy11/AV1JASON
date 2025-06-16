package application.geradores;

import java.util.ArrayList;
import java.util.List;

import entities.personagens.monstros.Monstro;

public class GerarMonstros {

    public static List<Monstro> monstrosNormais = new ArrayList<>();
    public static List<Monstro> monstrosElite = new ArrayList<>();
    public static List<Monstro> monstrosChefes = new ArrayList<>();

    public static void Turno() {
        String tipo;
    }

    public static void gerarTodosMonstros() {

        Monstro goblin = new Monstro("Goblin", 35, 35);
        goblin.setArmor(0); goblin.setForca(0); goblin.setDestreza(0);
        goblin.addTurno("Dano", 6);
        goblin.addTurno("Dano", 6);
        goblin.addTurno("Dano", 8);
        monstrosNormais.add(goblin);

        Monstro esqueleto = new Monstro("Esqueleto", 40, 40);
        esqueleto.setArmor(10); esqueleto.setForca(0); esqueleto.setDestreza(0);
        esqueleto.addTurno("Dano", 7);
        esqueleto.addTurno("Dano", 7);
        esqueleto.addTurno("Dano", 6);
        monstrosNormais.add(esqueleto);

        Monstro slime = new Monstro("Slime", 30, 30);
        slime.setArmor(0); slime.setForca(0); slime.setDestreza(0);
        slime.addTurno("Dano", 5);
        slime.addTurno("Dano", 5);
        slime.addTurno("Dano", 10);
        monstrosNormais.add(slime);

        Monstro morcego = new Monstro("Morcego", 45, 45);
        morcego.setArmor(0); morcego.setForca(0); morcego.setDestreza(0);
        morcego.addTurno("Dano", 8);
        morcego.addTurno("Dano", 8);
        morcego.addTurno("Escudo", 7);
        monstrosNormais.add(morcego);

        Monstro rato = new Monstro("Rato Gigante", 50, 50);
        rato.setArmor(0); rato.setForca(0); rato.setDestreza(0);
        rato.addTurno("Dano", 10);
        rato.addTurno("Dano", 10);
        rato.addTurno("Buff", 5);
        monstrosNormais.add(rato);

        Monstro orc = new Monstro("Orc Berserker", 90, 90);
        orc.setArmor(0); orc.setForca(0); orc.setDestreza(0);
        orc.addTurno("Dano", 10);
        orc.addTurno("Dano", 5);
        orc.addTurno("Dano", 12);
        orc.addTurno("Buff", 5);
        monstrosElite.add(orc);

        Monstro troll = new Monstro("Troll", 70, 70);
        troll.setArmor(0); troll.setForca(0); troll.setDestreza(0);
        troll.addTurno("Dano", 20);
        troll.addTurno("Dano", 20);
        troll.addTurno("Escudo", 10);
        monstrosElite.add(troll);

        Monstro minotauro = new Monstro("Minotauro", 130, 130);
        minotauro.setArmor(0); minotauro.setForca(0); minotauro.setDestreza(0);
        minotauro.addTurno("Dano", 8);
        minotauro.addTurno("Buff", 3);
        monstrosElite.add(minotauro);

        Monstro chefe = new Monstro("Rei Demônio", 180, 180);
        chefe.setArmor(0); chefe.setForca(0); chefe.setDestreza(0);
        chefe.addTurno("Dano", 28);
        chefe.addTurno("Dano", 12);
        chefe.addTurno("Escudo", 25);
        chefe.addTurno("Buff", 2);
        monstrosChefes.add(chefe);
    }
}
