public class Rummy extends Juego {

    public Rummy(int numeroJugadores, int numeroRondas) {
        super(numeroJugadores, numeroRondas);
    }

    @Override
    public void jugar() {
        System.out.println("Jugando Rummy...");
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            determinarGanadorRummy();
        }
    }

    private void determinarGanadorRummy() {
        Jugador ganador = null;
        int menorSuma = Integer.MAX_VALUE;

        for (Jugador jugador : jugadores) {
            int suma = jugador.getCartas().stream().mapToInt(Cartas::getValorNumerico).sum();
            System.out.println("Jugador " + jugador.getNombre() + " tiene " + suma + " puntos");
            if (suma < menorSuma) {
                menorSuma = suma;
                ganador = jugador;
            }
        }

        if (ganador != null) {
            ganador.sumarPunto();
            System.out.println("El ganador de esta ronda es: " + ganador.getNombre() + " con la suma más baja de puntos: " + menorSuma);
        }
    }
}
