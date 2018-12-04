package model;

public class Tablero {
	
	private int fila;
	private int columna;
	
	private int numeroDePozos;
	
	private int coordenadaFilaJugador;
	private int coordenadaColumnaJugador;
	
	private Celda celda[][];
	
	public Tablero() {	
	}
	
	public Tablero(int fila, int columna) {		
		this.fila = fila;
		this.columna = columna;
	}
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}

	public int getNumeroDePozos() {
		return numeroDePozos;
	}

	public void setNumeroDePozos(int numeroDePozos) {
		this.numeroDePozos = numeroDePozos;
	}
	
	public void tamañoTablero(int nuemroFilaColumna) {		
		this.fila = nuemroFilaColumna;
		this.columna = nuemroFilaColumna;
	}
	
	public Celda[][] getCelda() {
		return celda;
	}

	public void setCelda(Celda[][] celda) {
		this.celda = celda;
	}

	public int getCoordenadaFilaJugador() {
		return coordenadaFilaJugador;
	}

	public void setCoordenadaFilaJugador(int coordenadaFilaJugador) {
		this.coordenadaFilaJugador = coordenadaFilaJugador;
	}

	public int getCoordenadaColumnaJugador() {
		return coordenadaColumnaJugador;
	}

	public void setCoordenadaColumnaJugador(int coordenadaColumnaJugador) {
		this.coordenadaColumnaJugador = coordenadaColumnaJugador;
	}
	
}
