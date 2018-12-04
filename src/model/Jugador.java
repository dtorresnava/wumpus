package model;

public class Jugador {
	
	public static final int IZQUIERDA = 0;
	public static final int DERECHA = 1;
	public static final int ARRIBA = 2;
	public static final int ABAJO = 3;
	public static final int USAR_LANZA = 4;
	
	private String nombre;
	private int lanzas;
		
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public Jugador() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLanzas() {
		return lanzas;
	}

	public void setLanzas(int flechas) {
		this.lanzas = flechas;
	}
		
	
}
