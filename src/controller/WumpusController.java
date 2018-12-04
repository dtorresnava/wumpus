package controller;

import java.util.Scanner;

import message.ControllMessage;
import model.Celda;
import model.Jugador;
import model.Tablero;

public class WumpusController {
	
	private static ControllMessage mensaje;

	@SuppressWarnings("static-access")
	public boolean moverJugador(Tablero tablero, Jugador jugador) {
		boolean seguir = true;
		Scanner entrada = new Scanner(System.in);
		do {
			
			/*
			 * public static final String MENSAJE_ELEGIR_MOVIMIENTO = "¿Cual es tu siguiente movimiento?:";
				public static final String MENSAJE_SLECCIONAR_IZQUIERDA = "Opción 1, ir a la izquierda.";
				public static final String MENSAJE_SLECCIONAR_DERECHA = "Opción 2, ir a la derecha.";
				public static final String MENSAJE_SLECCIONAR_ARRIBA = "Opción 3, ir arriba.";
				public static final String MENSAJE_SLECCIONAR_ABAJO = "Opción 4, ir abajo.";
				public static final String MENSAJE_SLECCIONAR_LANZAR = "Opción 5, lanzar la lanza.";
			 * 
			 * */
			System.out.println(mensaje.MENSAJE_MOVIMIENTO);
			Celda celda[][] = tablero.getCelda();
			
			int fila = tablero.getCoordenadaFilaJugador();
			int columna = tablero.getCoordenadaColumnaJugador();
			
			if(fila == 0 && columna == 00) {
				if(celda[fila][fila].isBrisaHabilitada())
					System.out.println(mensaje.MENSAJE_BRISA_DETECTADA);
				if(celda[fila][fila].isEdorHabilitado())
					System.out.println(mensaje.MENSAJE_EDOR_DETECTADA);					
				
				System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);	
				
				System.out.println(mensaje.MENSAJE_ELEGIR_MOVIMIENTO);
				System.out.println(mensaje.MENSAJE_SLECCIONAR_DERECHA);
				System.out.println(mensaje.MENSAJE_SLECCIONAR_ABAJO);
				System.out.println(mensaje.MENSAJE_SLECCIONAR_LANZAR);				
				
				
			}
		}while(seguir);
		
		
		return false;
	}

}
