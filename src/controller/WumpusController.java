package controller;

import java.util.Scanner;

import message.ControllMessage;
import model.Celda;
import model.Jugador;
import model.Tablero;

public class WumpusController {

	private static ControllMessage mensaje;

	@SuppressWarnings({ "resource", "static-access" })
	public boolean moverJugador(Tablero tablero, Jugador jugador) {
		boolean seguir = true;
		boolean estadoPartida = false;
		Scanner entrada = new Scanner(System.in);

		TableroController construirTablero = new TableroController();

		do {
			Celda celda[][] = tablero.getCelda();
			int opcionJugador = 0;
			int fila = tablero.getCoordenadaFilaJugador();
			int columna = tablero.getCoordenadaColumnaJugador();

			if (fila == 0 && columna == 00) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesEsquina(fila, columna);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (fila == 0 && columna == tablero.getColumna() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesEsquina(fila, columna);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (fila == tablero.getFila() - 1 && columna == tablero.getColumna() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesEsquina(fila, columna);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (fila == tablero.getFila() - 1 && columna == 0) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesEsquina(fila, columna);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (fila == 0 && columna > 0 && columna < tablero.getColumna() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesfila(fila);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (fila == tablero.getFila() - 1 && columna > 0 && columna < tablero.getColumna() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesfila(fila);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (columna == 0 && fila > 0 && fila < tablero.getFila() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesColumna(columna);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (columna == tablero.getColumna() - 1 && fila > 0 && fila < tablero.getFila() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opcionesColumna(columna);
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			if (columna > 0 && columna < tablero.getColumna() - 1 && fila > 0 && fila < tablero.getFila() - 1) {
				comprobarPosicion(celda, fila, columna);
				if (celda[fila][columna].isWampusHabilitado() || celda[fila][columna].isPozoHabilitado()) {
					seguir = false;
					estadoPartida = false;
					if(celda[fila][columna].isWampusHabilitado()) {
						System.out.println(mensaje.MENSAJE_WUMPUS);
					}else {
						System.out.println(mensaje.MENSAJE_POZO);
					}
				}
				if (celda[fila][columna].isOroHabilitado()) {
					seguir = false;
					estadoPartida = true;
				}
				if (seguir) {
					opciones();
					opcionJugador = entrada.nextInt();
					realizarMovimientoJugador(opcionJugador, tablero, jugador, fila, columna);
				}
			}
			//construirTablero.mostrarTablero(tablero);
		} while (seguir);

		return estadoPartida;
	}

	@SuppressWarnings("static-access")
	private void opciones() {
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);
		System.out.println(mensaje.MENSAJE_ELEGIR_MOVIMIENTO);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_IZQUIERDA);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_DERECHA);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_ARRIBA);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_ABAJO);		
		System.out.println(mensaje.MENSAJE_SLECCIONAR_LANZAR);
	}

	@SuppressWarnings("static-access")
	private void opcionesfila(int fila) {
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);
		System.out.println(mensaje.MENSAJE_ELEGIR_MOVIMIENTO);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_IZQUIERDA);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_DERECHA);
		if (fila == 0) {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_ABAJO);
		} else {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_ARRIBA);
		}
		System.out.println(mensaje.MENSAJE_SLECCIONAR_LANZAR);
	}

	@SuppressWarnings("static-access")
	private void opcionesColumna(int columna) {
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);
		System.out.println(mensaje.MENSAJE_ELEGIR_MOVIMIENTO);
		if (columna == 0) {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_DERECHA);
		} else {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_IZQUIERDA);
		}
		System.out.println(mensaje.MENSAJE_SLECCIONAR_ARRIBA);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_ABAJO);
		System.out.println(mensaje.MENSAJE_SLECCIONAR_LANZAR);
	}

	@SuppressWarnings("static-access")
	private void opcionesEsquina(int fila, int columna) {
		System.out.print(mensaje.MENSAJE_SALTOS_DE_LINEA);
		System.out.println(mensaje.MENSAJE_ELEGIR_MOVIMIENTO);
		if (columna == 0) {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_DERECHA);
		} else {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_IZQUIERDA);
		}
		if (fila == 0) {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_ABAJO);
		} else {
			System.out.println(mensaje.MENSAJE_SLECCIONAR_ARRIBA);
		}
		System.out.println(mensaje.MENSAJE_SLECCIONAR_LANZAR);
	}

	@SuppressWarnings("static-access")
	private void comprobarPosicion(Celda[][] celda, int fila, int columna) {
		if (celda[fila][columna].isBrisaHabilitada())
			System.out.println(mensaje.MENSAJE_BRISA_DETECTADA);
		if (celda[fila][columna].isEdorHabilitado())
			System.out.println(mensaje.MENSAJE_EDOR_DETECTADA);
		if (celda[fila][columna].isMuroHabilitado())
			System.out.println(mensaje.MENSAJE_MURO_DETECTADO);
	}

	@SuppressWarnings("static-access")
	private void realizarMovimientoJugador(int opcionJugador, Tablero tablero, Jugador jugador, int fila, int columna) {

		switch (opcionJugador) {
			case 1: // ir izquierda
				if(columna-1 < 0) {
					System.out.println(mensaje.MENSAJE_DIRECCION_ERRONEA);
				}else {
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
					columna -= 1;
					tablero.setCoordenadaColumnaJugador(columna);
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
				}
				
				break;
			case 2: // ir derecha
				if(columna+1 == tablero.getColumna()) {
					System.out.println(mensaje.MENSAJE_DIRECCION_ERRONEA);
				}else {
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
					columna += 1;
					tablero.setCoordenadaColumnaJugador(columna);
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
				}
				break;
			case 3: // ir arriba
				if(fila-1 < 0) {
					System.out.println(mensaje.MENSAJE_DIRECCION_ERRONEA);
				}else {
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
					fila -= 1;
					tablero.setCoordenadaFilaJugador(fila);
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
				}
				break;
			case 4: // ir abajo
				if(fila+1 < 0) {
					System.out.println(mensaje.MENSAJE_DIRECCION_ERRONEA);
				}else {
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
					fila += 1;
					tablero.setCoordenadaFilaJugador(fila);
					tablero.getCelda()[fila][columna].setJugadorHabilitado(false);
				}
				break;
			case 5: // lanzar lanza
				if(jugador.getLanzas()== 0) {					
					System.out.println(mensaje.MENSAJE_SIN_LANZAS);
				}else {
					usarLanza(tablero, jugador, fila, columna);
				}
				
				break;
			default: // opción no válida
				break;
		}

	}

	@SuppressWarnings({ "static-access", "resource" })
	private void usarLanza(Tablero tablero, Jugador jugador, int fila, int columna) {
		Scanner entrada = new Scanner(System.in);
		int direccionLanza = 0;
		System.out.println(mensaje.MENSAJE_SELECCINA_DIRECCION);
		System.out.println(mensaje.MENSAJE_LANZAR_IZQUIERDA);
		System.out.println(mensaje.MENSAJE_LANZAR_DERECHA);
		System.out.println(mensaje.MENSAJE_LANZAR_ARRIBA);
		System.out.println(mensaje.MENSAJE_LANZAR_ABAJO);
		
		direccionLanza = entrada.nextInt();
		
		resultadoLanzarLanza(direccionLanza, fila, columna, tablero, jugador);
	}

	private void resultadoLanzarLanza(int direccionLanza, int fila, int columna, Tablero tablero, Jugador jugador) {
		switch (direccionLanza) {
			case 1: // ir izquierda				
				columna -= 1;
				comprobarMovimiento(tablero, jugador, fila, columna);				
				break;
			case 2: // ir derecha				
				columna += 1;
				comprobarMovimiento(tablero, jugador, fila, columna);
				break;
			case 3: // ir arriba				
				fila -= 1;
				comprobarMovimiento(tablero, jugador, fila, columna);
				break;
			case 4: // ir abajo				
				fila += 1;
				comprobarMovimiento(tablero, jugador, fila, columna);
				break;
			default: // opción no válida
				break;
		}
	}
	@SuppressWarnings("static-access")
	private void comprobarMovimiento(Tablero tablero, Jugador jugador, int fila, int columna) {
		if(tablero.getCelda()[fila][columna].isWampusHabilitado()) {
			tablero.getCelda()[fila][columna].setWampusHabilitado(false);
			eliminarEdor(tablero, fila, columna);
			System.out.println(mensaje.MENSAJE_WUMPUS_MUERTO);
		}
		int numeroLanzas = jugador.getLanzas();
		jugador.setLanzas(numeroLanzas-1);
	}

	private void eliminarEdor(Tablero tablero, int fila, int columna) {
		tablero.getCelda()[fila+1][columna].setEdorHabilitado(false);
		tablero.getCelda()[fila-1][columna].setEdorHabilitado(false);
		tablero.getCelda()[fila][columna+1].setEdorHabilitado(false);
		tablero.getCelda()[fila][columna-1].setEdorHabilitado(false);
	}

}
