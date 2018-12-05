package model;

public class Jugador {
	
	private String nombre;
	private boolean tieneOro;
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

	public boolean isTieneOro() {
		return tieneOro;
	}

	public void setTieneOro(boolean tieneOro) {
		this.tieneOro = tieneOro;
	}
	
}
