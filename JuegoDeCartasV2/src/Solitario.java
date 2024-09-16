public class Solitario extends Juego {

    public Solitario(int numeroJugadores, int numeroRondas) {
        super(numeroJugadores, numeroRondas);
    }

    @Override
    public void jugar() {
        System.out.println("Jugando Solitario...");
        System.out.println("Solitario es un juego individual, no hay ganadores entre jugadores.");
        // Aquí podrías implementar la lógica del Solitario.
    }
}
