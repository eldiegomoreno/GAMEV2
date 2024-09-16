public class Hearts extends Juego {

    public Hearts(int numeroJugadores, int numeroRondas) {
        super(numeroJugadores, numeroRondas);
    }

    @Override
    public void jugar() {
        System.out.println("Jugando Hearts...");
        for (int ronda = 0; ronda < numeroRondas; ronda++) {
            System.out.println("Ronda: " + (ronda + 1));
            this.cartas = crearBaraja();
            barajar();
            repartirCartas();
            mostrarCartas();
            determinarGanadorHearts();
        }
    }

    private void determinarGanadorHearts() {
        Jugador ganador = null;
        int menorPenalizacion = Integer.MAX_VALUE;

        for (Jugador jugador : jugadores) {
            long cartasPenalizadoras = jugador.getCartas().stream()
                    .filter(carta -> carta.getSimbolo().equals("Corazón") || (carta.getValor().equals("Q") && carta.getSimbolo().equals("Espadas")))
                    .count();

            System.out.println("Jugador " + jugador.getNombre() + " tiene " + cartasPenalizadoras + " cartas penalizadoras");

            if (cartasPenalizadoras < menorPenalizacion) {
                menorPenalizacion = (int) cartasPenalizadoras;
                ganador = jugador;
            }
        }

        if (ganador != null) {
            ganador.sumarPunto();
            System.out.println("El ganador de esta ronda es: " + ganador.getNombre() + " con " + menorPenalizacion + " cartas penalizadoras.");
        }
    }
}
