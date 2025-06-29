package unq.cazaDeVinchucas.usuario;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.java.unq.cazaDeVinchucas.modelo.usuario.Especialista;

public class EspecialistaTest {
	
	Especialista especialista;
	
	@Before
	public void setUp() {
		especialista = new Especialista();
	}
	
	@Test
	public void cumpleCondicionDeExperto() {
		assertTrue(especialista.cumpleCondicionDeExperto());
	}
	
}
