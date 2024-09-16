public class Cartas {
    private String valor;
    private String simbolo;

    public Cartas(String valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }

    public String getValor() {
        return valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    // Asignar valores numéricos a las cartas para BlackJack o Poker
    public int getValorNumerico() {
        switch (valor) {
            case "As": return 11; // o 1 dependiendo de BlackJack
            case "J": case "Q": case "K": return 10;
            default: return Integer.parseInt(valor);
        }
    }

    @Override
    public String toString() {
        return valor + " de " + simbolo;
    }
}
