package controller;

import model.Celda;
import model.Tablero;

public class TableroController {

	/**
	 * Construimos el tablero pasando el numero de filas y columnas
	 */

	private static final int NUMERO_MUROS = 1;

	public void construirTablero(Tablero tablero) {
		Celda celda[][] = new Celda[tablero.getFila()][tablero.getColumna()];

		for (int i = 0; i < tablero.getFila(); i++) {
			for (int j = 0; j < tablero.getColumna(); j++) {
				celda[i][j] = new Celda(false, false, false, false, false, false, false);
			}
		}

		introducirPozos(tablero, celda);
		colocarMuro(tablero, celda);
		colocarWumpus(tablero, celda);
		colocarJugador(tablero, celda);
		colocarOro(tablero, celda);
		tablero.setCelda(celda);
	}

	public void colocarOro(Tablero tablero, Celda[][] celda) {
		int fila = 0;
		int columna = 0;
		boolean oroHabilitado = false;
		do {
			fila = (int) Math.floor(Math.random() * tablero.getFila());
			columna = (int) Math.floor(Math.random() * tablero.getColumna());

			if (!celda[fila][columna].isPozoHabilitado() && !celda[fila][columna].isMuroHabilitado()
					&& !celda[fila][columna].isWampusHabilitado() && !celda[fila][columna].isJugadorHabilitado()) {
				celda[fila][columna].setOroHabilitado(true);
				oroHabilitado = true;
			}
		} while (oroHabilitado == false);
	}

	public void colocarJugador(Tablero tablero, Celda[][] celda) {
		int fila = 0;
		int columna = 0;
		boolean jugadorHabilitado = false;
		do {
			fila = (int) Math.floor(Math.random() * tablero.getFila());
			columna = (int) Math.floor(Math.random() * tablero.getColumna());

			if (!celda[fila][columna].isPozoHabilitado() && !celda[fila][columna].isMuroHabilitado()
					&& !celda[fila][columna].isWampusHabilitado()) {
				celda[fila][columna].setJugadorHabilitado(true);
				jugadorHabilitado = true;
				
				tablero.setCoordenadaFilaJugador(fila);
				tablero.setCoordenadaColumnaJugador(columna);
				
				tablero.setCoordenadaFilaIni(fila);
				tablero.setCoordenadaColumnaIni(columna);
			}
		} while (jugadorHabilitado == false);
	}

	public void colocarWumpus(Tablero tablero, Celda[][] celda) {
		int fila = 0;
		int columna = 0;
		boolean wumpusHabilitado = false;
		do {
			fila = (int) Math.floor(Math.random() * tablero.getFila());
			columna = (int) Math.floor(Math.random() * tablero.getColumna());

			if (!celda[fila][columna].isPozoHabilitado() && !celda[fila][columna].isMuroHabilitado()) {
				celda[fila][columna].setWampusHabilitado(true);
				colocarEdor(tablero, celda, fila, columna);
				wumpusHabilitado = true;
			}
		} while (wumpusHabilitado == false);

	}

	private void colocarEdor(Tablero tablero, Celda[][] celda, int fila, int columna) {

		if (fila - 1 >= 0)
			celda[fila - 1][columna].setEdorHabilitado(true);
		if (fila + 1 < tablero.getFila())
			celda[fila + 1][columna].setEdorHabilitado(true);
		if (columna - 1 >= 0)
			celda[fila][columna - 1].setEdorHabilitado(true);
		if (columna + 1 < tablero.getColumna())
			celda[fila][columna + 1].setEdorHabilitado(true);
	}

	public void introducirPozos(Tablero tablero, Celda celda[][]) {
		int fila = 0;
		int columna = 0;
		for (int i = 0; i < tablero.getNumeroDePozos(); i++) {
			fila = (int) Math.floor(Math.random() * tablero.getFila());
			columna = (int) Math.floor(Math.random() * tablero.getColumna());

			if (!celda[fila][columna].isPozoHabilitado()) {
				celda[fila][columna].setPozoHabilitado(true);
			}
		}
		colocarBrisa(tablero, celda);
	}

	public void colocarMuro(Tablero tablero, Celda[][] celda) {
		int cont = NUMERO_MUROS;
		int fila = 0;
		int columna = 0;
		do {
			fila = (int) Math.floor(Math.random() * tablero.getFila());
			columna = (int) Math.floor(Math.random() * tablero.getColumna());
			if (!celda[fila][columna].isPozoHabilitado()) {
				celda[fila][columna].setMuroHabilitado(true);
				cont = 0;
			}
		} while (cont != 0);
	}

	private void colocarBrisa(Tablero tablero, Celda[][] celda) {
		for (int i = 0; i < tablero.getFila(); i++) {
			for (int j = 0; j < tablero.getColumna(); j++) {
				if (celda[i][j].isPozoHabilitado()) {
					if (i == 0 && j == 0 && celda[i][j].isPozoHabilitado()) {
						if (!celda[i][j + 1].isPozoHabilitado()) {
							celda[i][j + 1].setBrisaHabilitada(true);
						}
						if (!celda[i + 1][j].isPozoHabilitado()) {
							celda[i + 1][j].setBrisaHabilitada(true);
						}
					}

					if (i == 0 && j == tablero.getColumna() - 1 && celda[i][j].isPozoHabilitado()) {
						if (!celda[i][j - 1].isPozoHabilitado()) {
							celda[i][j - 1].setBrisaHabilitada(true);
						}
						if (!celda[i + 1][j].isPozoHabilitado()) {
							celda[i + 1][j].setBrisaHabilitada(true);
						}
					}

					if (i == tablero.getFila() - 1 && j == 0 && celda[i][j].isPozoHabilitado()) {
						if (!celda[i][j + 1].isPozoHabilitado()) {
							celda[i][j + 1].setBrisaHabilitada(true);
						}
						if (!celda[i - 1][j].isPozoHabilitado()) {
							celda[i - 1][j].setBrisaHabilitada(true);
						}
					}

					if (i == tablero.getFila() - 1 && j == tablero.getColumna() - 1 && celda[i][j].isPozoHabilitado()) {
						if (!celda[i][j - 1].isPozoHabilitado()) {
							celda[i][j - 1].setBrisaHabilitada(true);
						}
						if (!celda[i - 1][j].isPozoHabilitado()) {
							celda[i - 1][j].setBrisaHabilitada(true);
						}
					}

					if (i == 0 && j > 0 && j < tablero.getColumna() - 1 && celda[i][j].isPozoHabilitado()) {
						if (!celda[i][j + 1].isPozoHabilitado()) {
							celda[i][j + 1].setBrisaHabilitada(true);
						}
						if (!celda[i][j - 1].isPozoHabilitado()) {
							celda[i][j - 1].setBrisaHabilitada(true);
						}
						if (!celda[i + 1][j].isPozoHabilitado()) {
							celda[i + 1][j].setBrisaHabilitada(true);
						}
					}

					if (i == tablero.getFila() - 1 && j > 0 && j < tablero.getColumna() - 1
							&& celda[i][j].isPozoHabilitado()) {
						if (!celda[i][j + 1].isPozoHabilitado()) {
							celda[i][j + 1].setBrisaHabilitada(true);
						}
						if (!celda[i][j - 1].isPozoHabilitado()) {
							celda[i][j - 1].setBrisaHabilitada(true);
						}
						if (!celda[i - 1][j].isPozoHabilitado()) {
							celda[i - 1][j].setBrisaHabilitada(true);
						}
					}

					if (j == 0 && i > 0 && i < tablero.getFila() - 1 && celda[i][j].isPozoHabilitado()) {
						if (!celda[i + 1][j].isPozoHabilitado()) {
							celda[i + 1][j].setBrisaHabilitada(true);
						}
						if (!celda[i - 1][j].isPozoHabilitado()) {
							celda[i - 1][j].setBrisaHabilitada(true);
						}
						if (!celda[i][j + 1].isPozoHabilitado()) {
							celda[i][j + 1].setBrisaHabilitada(true);
						}
					}

					if (j == tablero.getColumna() - 1 && i > 0 && i < tablero.getFila() - 1
							&& celda[i][j].isPozoHabilitado()) {
						if (!celda[i + 1][j].isPozoHabilitado()) {
							celda[i + 1][j].setBrisaHabilitada(true);
						}
						if (!celda[i - 1][j].isPozoHabilitado()) {
							celda[i - 1][j].setBrisaHabilitada(true);
						}
						if (!celda[i][j - 1].isPozoHabilitado()) {
							celda[i][j - 1].setBrisaHabilitada(true);
						}
					}

					if (i > 0 && i < tablero.getFila() - 1 && j > 0 && j < tablero.getColumna() - 1
							&& celda[i][j].isPozoHabilitado()) {
						if (!celda[i + 1][j].isPozoHabilitado()) {
							celda[i + 1][j].setBrisaHabilitada(true);
						}
						if (!celda[i - 1][j].isPozoHabilitado()) {
							celda[i - 1][j].setBrisaHabilitada(true);
						}
						if (!celda[i][j - 1].isPozoHabilitado()) {
							celda[i][j - 1].setBrisaHabilitada(true);
						}
						if (!celda[i][j + 1].isPozoHabilitado()) {
							celda[i][j + 1].setBrisaHabilitada(true);
						}
					}
				}
			}
		}
	}

	public void mostrarTablero(Tablero tablero) {
		for (int i = 0; i < tablero.getFila(); i++) {
			for (int j = 0; j < tablero.getColumna(); j++) {
				if (tablero.getCelda()[i][j].isPozoHabilitado()) {
					System.out.print("[ POZO  ] ");
				} else if (tablero.getCelda()[i][j].isOroHabilitado()) {
					System.out.print("[ ORO   ] ");
				} else if (tablero.getCelda()[i][j].isJugadorHabilitado()) {
					System.out.print("[JUGADOR] ");
				} else if (tablero.getCelda()[i][j].isBrisaHabilitada() && tablero.getCelda()[i][j].isMuroHabilitado()
						&& tablero.getCelda()[i][j].isEdorHabilitado()) {
					System.out.print("[ B/M/E ] ");
				} else if (tablero.getCelda()[i][j].isBrisaHabilitada()
						&& tablero.getCelda()[i][j].isMuroHabilitado()) {
					System.out.print("[ BR/MU ] ");
				} else if (tablero.getCelda()[i][j].isEdorHabilitado() && tablero.getCelda()[i][j].isMuroHabilitado()) {
					System.out.print("[ ED/MU ] ");
				} else if (tablero.getCelda()[i][j].isEdorHabilitado()
						&& tablero.getCelda()[i][j].isBrisaHabilitada()) {
					System.out.print("[ ED/BR ] ");
				} else if (tablero.getCelda()[i][j].isWampusHabilitado()
						&& tablero.getCelda()[i][j].isBrisaHabilitada()) {
					System.out.print("[ WU/BR ] ");
				} else if (tablero.getCelda()[i][j].isMuroHabilitado()) {
					System.out.print("[ MURO  ] ");
				} else if (tablero.getCelda()[i][j].isWampusHabilitado()) {
					System.out.print("[ WUMPU ] ");
				} else if (tablero.getCelda()[i][j].isBrisaHabilitada()) {
					System.out.print("[ BRISA ] ");
				} else if (tablero.getCelda()[i][j].isEdorHabilitado()) {
					System.out.print("[ EDOR  ] ");
				} else {
					System.out.print("[       ] ");
				}

			}
			System.out.print("\n");
		}
	}

}
