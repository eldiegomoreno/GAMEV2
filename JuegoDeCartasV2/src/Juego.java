import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Juego {
    protected List<Jugador> jugadores;
    protected List<Cartas> cartas;
    protected int numeroRondas;

    public Juego(int numeroJugadores, int numeroRondas) {
        this.jugadores = crearJugadores(numeroJugadores);
        this.numeroRondas = numeroRondas;
    }

    protected List<Jugador> crearJugadores(int numeroJugadores) {
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < numeroJugadores; i++) {
            jugadores.add(new Jugador("Jugador" + (i + 1), 50));
        }
        return jugadores;
    }

    protected List<Cartas> crearBaraja() {
        List<Cartas> baraja = new ArrayList<>();
        String[] simbolos = {"Corazón", "Diamante", "Trébol", "Espadas"};
        String[] valores = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String simbolo : simbolos) {
            for (String valor : valores) {
                baraja.add(new Cartas(valor, simbolo));
            }
        }
        return baraja;
    }

    protected void barajar() {
        Collections.shuffle(cartas);
    }

    protected void repartirCartas() {
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < 5; i++) {
                jugador.agregarCarta(cartas.remove(0));
            }
        }
    }

    protected void mostrarCartas() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre() + ": " + jugador.getCartas());
        }
    }

    public abstract void jugar();
}
