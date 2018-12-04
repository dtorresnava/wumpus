package wumpus;

import java.util.Scanner;

import controller.TableroController;
import controller.WumpusController;
import message.ControllMessage;
import model.Jugador;
import model.Tablero;

public class Wumpus {
	
	private static ControllMessage mensaje;
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		boolean terminar = init();		
		
		if(terminar) {
			System.out.println("Has ganado");
		}else {
			System.out.println("Has perdido");
		}
	}
	
	public static boolean init() {
		boolean salir = false;			
		Jugador jugador = new Jugador();
		Tablero tablero = new Tablero();
		
		Scanner entrada = new Scanner(System.in);
		mostrarInicio();
		introducirDatosJugador(jugador, entrada);
		introducirDatosTablero(tablero, entrada);
		mostrarDatosJugador(jugador, tablero);		
		
		TableroController construirTablero = new TableroController();		
		construirTablero.construirTablero(tablero);
		construirTablero.mostrarTablero(tablero);
		
		WumpusController jugarWumpus = new WumpusController();
		salir = jugarWumpus.moverJugador(tablero, jugador);
		return salir;
	}
	
	@SuppressWarnings("static-access")
	private static void mostrarDatosJugador(Jugador jugador, Tablero tablero) {
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);	
		System.out.println(mensaje.MENSAJE_DATOS_JUGADOR);
		System.out.print(mensaje.MENSAJE_NOMBRE);
		System.out.println(jugador.getNombre());
		System.out.print(mensaje.MENSAJE_NUMERO_LANZAS);
		System.out.println(jugador.getLanzas());
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);
	}

	@SuppressWarnings("static-access")
	private static void mostrarInicio() {
		System.out.println(mensaje.MENSJE_BIENVENIDA);
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);		
	} 
	
	@SuppressWarnings("static-access")
	private static void introducirDatosJugador(Jugador jugador, Scanner entrada) {		
		System.out.print(mensaje.MENSAJE_INTRODUCE_NOMBRE_JUGADOR);		
		jugador.setNombre(entrada.nextLine());		
		System.out.print(mensaje.MENSAJE_INTRODUCIR_NUMERO_LANZAS);		
		jugador.setLanzas(entrada.nextInt());
	}
	
	@SuppressWarnings("static-access")
	private static void introducirDatosTablero(Tablero tablero, Scanner entrada) {
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);
		System.out.print(mensaje.MENSAJE_INTRODUCE_TAMANYO_TABLERO);
		tablero.tamañoTablero(entrada.nextInt());		
		System.out.print(mensaje.MENSAJE_INTRODUCIR_NUMERO_POZOS);
		tablero.setNumeroDePozos(entrada.nextInt());
	}
}
