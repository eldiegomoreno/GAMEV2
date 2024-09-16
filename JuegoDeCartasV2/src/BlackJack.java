public class BlackJack extends Juego {

    public BlackJack(int numeroJugadores, int numeroRondas) {
        super(numeroJugadores, numeroRondas);
    }

    @Override
    public void jugar() {
        System.out.println("Jugando BlackJack...");
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            determinarGanadorBlackJack();
        }
    }

    private void determinarGanadorBlackJack() {
        Jugador ganador = null;
        int mejorPuntuacion = 0;

        for (Jugador jugador : jugadores) {
            int suma = jugador.getCartas().stream().mapToInt(Cartas::getValorNumerico).sum();
            System.out.println("Jugador " + jugador.getNombre() + " tiene " + suma + " puntos");
            if (suma <= 21 && suma > mejorPuntuacion) {
                mejorPuntuacion = suma;
                ganador = jugador;
            }
        }

        if (ganador != null) {
            ganador.sumarPunto();
            System.out.println("El ganador de esta ronda es: " + ganador.getNombre() + " con " + mejorPuntuacion + " puntos.");
        } else {
            System.out.println("Nadie ganó esta ronda.");
        }
    }
}
