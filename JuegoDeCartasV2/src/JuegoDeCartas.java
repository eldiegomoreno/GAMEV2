import java.util.Scanner;

public class JuegoDeCartas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de jugadores:");
        int numJugadores = sc.nextInt();

        System.out.println("Ingrese el número de rondas:");
        int numRondas = sc.nextInt();

        System.out.println("Seleccione el juego: 1. BlackJack, 2. Poker, 3. Rummy, 4. Hearts, 5. Solitario");
        int seleccionJuego = sc.nextInt();

        Juego juego;
        switch (seleccionJuego) {
            case 1:
                juego = new BlackJack(numJugadores, numRondas);
                break;
            case 2:
                juego = new Poker(numJugadores, numRondas);
                break;
            case 3:
                juego = new Rummy(numJugadores, numRondas);
                break;
            case 4:
                juego = new Hearts(numJugadores, numRondas);
                break;
            case 5:
                juego = new Solitario(numJugadores, numRondas);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        juego.jugar();
    }
}
