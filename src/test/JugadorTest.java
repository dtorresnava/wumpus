package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Jugador;

public class JugadorTest {

	@Test
	public void test() {
		Jugador jugador = new Jugador();
		jugador.setNombre("Diego");		
		assertEquals("Diego", jugador.getNombre());
		
		jugador.setLanzas(5);
		assertEquals(5, jugador.getLanzas());
		
		jugador.setTieneOro(false);
		assertEquals(false, jugador.isTieneOro());
	}

}
