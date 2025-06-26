package unq.cazaDeVinchucas.usuario;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.unq.cazaDeVinchucas.modelo.usuario.Especialista;

public class EspecialistaTest {
	
	Especialista especialista;
	
	@BeforeEach
	public void setUp() {
		especialista = new Especialista();
	}
	/*
		@Test
		public void cumpleCondicionDeExperto() {
			assertTrue(especialista.cumpleCondicionDeExperto());
		}
	*/
}
