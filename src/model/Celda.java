package model;

public class Celda {
	
	private boolean wampusHabilitado;
	private boolean muroHabilitado;
	private boolean pozoHabilitado;
	private boolean oroHabilitado;
	private boolean jugadorHabilitado;
	
	private boolean brisaHabilitada;
	private boolean edorHabilitado;
	
	public Celda() {
		
	}

		
	public Celda(boolean wampusHabilitado, boolean muroHabilitado, boolean pozoHabilitado, boolean oroHabilitado,
			boolean brisaHabilitada, boolean edorHabilitado, boolean jugadorHabilitado) {		
		this.wampusHabilitado = wampusHabilitado;
		this.muroHabilitado = muroHabilitado;
		this.pozoHabilitado = pozoHabilitado;
		this.oroHabilitado = oroHabilitado;
		this.brisaHabilitada = brisaHabilitada;
		this.edorHabilitado = edorHabilitado;
		this.jugadorHabilitado = jugadorHabilitado;
	}


	public boolean isWampusHabilitado() {
		return wampusHabilitado;
	}

	public void setWampusHabilitado(boolean wampusHabilitado) {
		this.wampusHabilitado = wampusHabilitado;
	}

	public boolean isMuroHabilitado() {
		return muroHabilitado;
	}

	public void setMuroHabilitado(boolean muroHabilitado) {
		this.muroHabilitado = muroHabilitado;
	}

	public boolean isPozoHabilitado() {
		return pozoHabilitado;
	}

	public void setPozoHabilitado(boolean pozoHabilitado) {
		this.pozoHabilitado = pozoHabilitado;
	}

	public boolean isOroHabilitado() {
		return oroHabilitado;
	}

	public void setOroHabilitado(boolean oroHabilitado) {
		this.oroHabilitado = oroHabilitado;
	}

	public boolean isBrisaHabilitada() {
		return brisaHabilitada;
	}

	public void setBrisaHabilitada(boolean brisaHabilitada) {
		this.brisaHabilitada = brisaHabilitada;
	}

	public boolean isEdorHabilitado() {
		return edorHabilitado;
	}

	public void setEdorHabilitado(boolean edorHabilitado) {
		this.edorHabilitado = edorHabilitado;
	}

	public boolean isJugadorHabilitado() {
		return jugadorHabilitado;
	}

	public void setJugadorHabilitado(boolean jugadorHabilitado) {
		this.jugadorHabilitado = jugadorHabilitado;
	}	
}
