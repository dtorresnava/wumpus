package controller;

import model.Celda;
import model.Tablero;

public class TableroController {	
	
	/**
	 * Construimos el tablero pasando el numero de filas y columnas
	 * */
	
	private static final int NUMERO_MUROS = 1;
	public void construirTablero(Tablero tablero) {
		Celda celda[][] =  new Celda[tablero.getFila()][tablero.getColumna()];		
				
		for(int i=0; i<tablero.getFila(); i++) {
			for(int j=0; j<tablero.getColumna(); j++) {
				celda[i][j] = new Celda(false, false, false, false,false,false); 
			}			
		}
		
		introducirPozos(tablero,celda);
		
		tablero.setCelda(celda);
	}

	private void introducirPozos(Tablero tablero, Celda celda[][]) {
		int fila = 0;
		int columna = 0;
		for(int i = 0; i<tablero.getNumeroDePozos(); i++) {
			fila = (int) Math.floor(Math.random()*tablero.getFila());
			columna = (int) Math.floor(Math.random()*tablero.getColumna());
			
			if(!celda[fila][columna].isPozoHabilitado()) {
				celda[fila][columna].setPozoHabilitado(true);
			}			
		}
		colocarBrisa(tablero, celda);
		colocarMuro(tablero, celda);
	}

	private void colocarMuro(Tablero tablero, Celda[][] celda) {
		int cont = NUMERO_MUROS;
		int fila = 0;
		int columna = 0;
		do {
			fila = (int) Math.floor(Math.random()*tablero.getFila());
			columna = (int) Math.floor(Math.random()*tablero.getColumna());
			if(!celda[fila][columna].isPozoHabilitado()) {
				celda[fila][columna].setMuroHabilitado(true);
				cont=0;
			}
		}while(cont!=0);		
	}

	private void colocarBrisa(Tablero tablero, Celda[][] celda) {
		for(int i=0; i<tablero.getFila(); i++) {
			for(int j=0; j<tablero.getColumna(); j++) {
				if(celda[i][j].isPozoHabilitado()) {					
					if(i==0 && j==0 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i][j+1].isPozoHabilitado()) {
							celda[i][j+1].setBrisaHabilitada(true);
						}
						if(!celda[i+1][j].isPozoHabilitado()) {
							celda[i+1][j].setBrisaHabilitada(true);
						}
					}
					
					if(i==0 && j==tablero.getColumna()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i][j-1].isPozoHabilitado()) {
							celda[i][j-1].setBrisaHabilitada(true);
						}
						if(!celda[i+1][j].isPozoHabilitado()) {
							celda[i+1][j].setBrisaHabilitada(true);
						}
					}
					
					if(i==tablero.getFila()-1 && j==0 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i][j+1].isPozoHabilitado()) {
							celda[i][j+1].setBrisaHabilitada(true);
						}
						if(!celda[i-1][j].isPozoHabilitado()) {
							celda[i-1][j].setBrisaHabilitada(true);
						}
					}
					
					if(i==tablero.getFila()-1 && j==tablero.getColumna()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i][j-1].isPozoHabilitado()) {
							celda[i][j-1].setBrisaHabilitada(true);
						}
						if(!celda[i-1][j].isPozoHabilitado()) {
							celda[i-1][j].setBrisaHabilitada(true);
						}
					}
					
					if(i==0 && j>0 && j<tablero.getColumna()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i][j+1].isPozoHabilitado()) {
							celda[i][j+1].setBrisaHabilitada(true);
						}
						if(!celda[i][j-1].isPozoHabilitado()) {
							celda[i][j-1].setBrisaHabilitada(true);
						}
						if(!celda[i+1][j].isPozoHabilitado()) {
							celda[i+1][j].setBrisaHabilitada(true);
						}
					}
					
					if(i==tablero.getFila()-1 && j>0 && j<tablero.getColumna()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i][j+1].isPozoHabilitado()) {
							celda[i][j+1].setBrisaHabilitada(true);
						}
						if(!celda[i][j-1].isPozoHabilitado()) {
							celda[i][j-1].setBrisaHabilitada(true);
						}
						if(!celda[i-1][j].isPozoHabilitado()) {
							celda[i-1][j].setBrisaHabilitada(true);
						}
					}
					
					if(j==0 && i>0 && i<tablero.getFila()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i+1][j].isPozoHabilitado()) {
							celda[i+1][j].setBrisaHabilitada(true);
						}
						if(!celda[i-1][j].isPozoHabilitado()) {
							celda[i-1][j].setBrisaHabilitada(true);
						}
						if(!celda[i][j+1].isPozoHabilitado()) {
							celda[i][j+1].setBrisaHabilitada(true);
						}
					}
					
					if(j==tablero.getColumna()-1 && i>0 && i<tablero.getFila()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i+1][j].isPozoHabilitado()) {
							celda[i+1][j].setBrisaHabilitada(true);
						}
						if(!celda[i-1][j].isPozoHabilitado()) {
							celda[i-1][j].setBrisaHabilitada(true);
						}
						if(!celda[i][j-1].isPozoHabilitado()) {
							celda[i][j-1].setBrisaHabilitada(true);
						}
					}
					
					if(i>0 && i<tablero.getFila()-1  && j>0 && j<tablero.getColumna()-1 && celda[i][j].isPozoHabilitado()) {
						if(!celda[i+1][j].isPozoHabilitado()) {
							celda[i+1][j].setBrisaHabilitada(true);
						}
						if(!celda[i-1][j].isPozoHabilitado()) {
							celda[i-1][j].setBrisaHabilitada(true);
						}
						if(!celda[i][j-1].isPozoHabilitado()) {
							celda[i][j-1].setBrisaHabilitada(true);
						}
						if(!celda[i][j+1].isPozoHabilitado()) {
							celda[i][j+1].setBrisaHabilitada(true);
						}
					}
				}
			}				
		}
	}

	public void mostrarTablero(Tablero tablero) {
		for(int i=0; i<tablero.getFila(); i++) {
			for(int j=0; j<tablero.getColumna(); j++) {
				if(tablero.getCelda()[i][j].isPozoHabilitado()) {
					System.out.print("[ POZO  ] ");
				}
				else if(tablero.getCelda()[i][j].isBrisaHabilitada() && tablero.getCelda()[i][j].isMuroHabilitado()) {
					System.out.print("[ BR/MU ] ");
				}
				else if(tablero.getCelda()[i][j].isMuroHabilitado()) {
					System.out.print("[ MURO  ] ");
				}
				else if(tablero.getCelda()[i][j].isBrisaHabilitada()) {
					System.out.print("[ BRISA ] ");
				}
				else {
					System.out.print("[       ] ");
				}
								 
			}	
			System.out.print("\n");
		}
	}

	
}
