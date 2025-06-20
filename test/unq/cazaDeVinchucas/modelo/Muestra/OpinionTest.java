package unq.cazaDeVinchucas.modelo.Muestra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class OpinionTest {
	Usuario usuarioMock;
	Muestra muestraMock;
	String opinion;
	Opinion opinionTest;
	
	@Before
	public void setUp() {
		usuarioMock = mock(Usuario.class);
		muestraMock = mock(Muestra.class);
		opinion = "Vinchuca";
		when(usuarioMock.nivelDeUsuario()).thenReturn("Experto");
		
		opinionTest = new Opinion(usuarioMock, muestraMock, opinion);
	}
	
	@Test
	public void getUsuario() {
		assertEquals(usuarioMock, opinionTest.getUsuario());
	}
	
	@Test
	public void getMuestra() {
		assertEquals(muestraMock, opinionTest.getMuestra());
	}
	
	@Test
	public void getOpinion() {
		assertEquals("Vinchuca", opinionTest.getOpinion());
	}
	
	@Test
	public void getTipo() {
		assertEquals("Experto", opinionTest.getTipo());
	}
}
