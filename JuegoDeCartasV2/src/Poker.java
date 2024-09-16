public class Poker extends Juego {

    public Poker(int numeroJugadores, int numeroRondas) {
        super(numeroJugadores, numeroRondas);
    }

    @Override
    public void jugar() {
        System.out.println("Jugando Poker...");
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            determinarGanadorPoker();
        }
    }

    private void determinarGanadorPoker() {
        Jugador ganador = null;
        Cartas mejorCarta = null;

        for (Jugador jugador : jugadores) {
            Cartas cartaMax = jugador.getCartas().stream().max((carta1, carta2) -> Integer.compare(carta1.getValorNumerico(), carta2.getValorNumerico())).get();
            System.out.println("Jugador " + jugador.getNombre() + " tiene la carta más alta: " + cartaMax);

            if (mejorCarta == null || cartaMax.getValorNumerico() > mejorCarta.getValorNumerico()) {
                mejorCarta = cartaMax;
                ganador = jugador;
            }
        }

        if (ganador != null) {
            ganador.sumarPunto();
            System.out.println("El ganador de esta ronda es: " + ganador.getNombre() + " con la carta más alta: " + mejorCarta);
        } else {
            System.out.println("Nadie ganó esta ronda.");
        }
    }
}
