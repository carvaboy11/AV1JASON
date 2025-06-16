package application.utility;

public class Jornada {
    private int inimigosDerrotados;
    private int elitesDerrotados;
    private int chefesDerrotados;
    private int cartasUsadas;
    private boolean heroiSobreviveu = true;
    private String causaDaMorte = "";

    public void registrarInimigo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "normal" -> inimigosDerrotados++;
            case "elite" -> elitesDerrotados++;
            case "chefe" -> chefesDerrotados++;
        }
    }

    public void registrarCartaUsada() {
        cartasUsadas++;
    }

    public void setHeroiSobreviveu(boolean vivo) {
        heroiSobreviveu = vivo;
    }

    public void setCausaDaMorte(String causa) {
        causaDaMorte = causa;
    }

    public int getInimigosDerrotados() {
        return inimigosDerrotados;
    }

    public int getElitesDerrotados() {
        return elitesDerrotados;
    }

    public int getChefesDerrotados() {
        return chefesDerrotados;
    }

    public int getCartasUsadas() {
        return cartasUsadas;
    }

    public boolean getHeroiSobreviveu() {
        return heroiSobreviveu;
    }

    public String getCausaDaMorte() {
        return causaDaMorte;
    }
}