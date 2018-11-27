package model;

public class Tablero {
	
	private int fila;
	private int columna;
	
	private int numeroDeWampus;
	private int numeroDeMuros;
	private int numeroDePozos;
	
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

	public int getNumeroDeWampus() {
		return numeroDeWampus;
	}

	public void setNumeroDeWampus(int numeroDeWampus) {
		this.numeroDeWampus = numeroDeWampus;
	}

	public int getNumeroDeMuros() {
		return numeroDeMuros;
	}

	public void setNumeroDeMuros(int numeroDeMuros) {
		this.numeroDeMuros = numeroDeMuros;
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
	
}
