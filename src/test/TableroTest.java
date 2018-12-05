package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.TableroController;
import model.Celda;
import model.Tablero;

public class TableroTest {

	@Test
	public void test() {
		Tablero tablero = new Tablero();
		int fila = (int) Math.floor(Math.random() * 10);
		int columna = (int) Math.floor(Math.random() * 10);
		
		tablero.setFila(fila);
		tablero.setColumna(columna);
		
		assertEquals(fila,tablero.getFila());
		assertEquals(columna,tablero.getColumna());
		
						
		Celda celda[][] = new Celda[tablero.getFila()][tablero.getColumna()];

		for (int i = 0; i < tablero.getFila(); i++) {
			for (int j = 0; j < tablero.getColumna(); j++) {
				celda[i][j] = new Celda(false, false, false, false, false, false, false);
			}
		}
		TableroController tableroController = new TableroController();
		tableroController.introducirPozos(tablero, celda);
		tableroController.colocarMuro(tablero, celda);
		tableroController.colocarWumpus(tablero, celda);
		tableroController.colocarJugador(tablero, celda);
		tableroController.colocarOro(tablero, celda);
		
		tablero.setCelda(celda);
		
		assertArrayEquals(celda, tablero.getCelda());
	}
	

}
