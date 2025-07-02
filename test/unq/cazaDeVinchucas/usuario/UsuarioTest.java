package unq.cazaDeVinchucas.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoMuestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class UsuarioTest {
	
	Usuario user;
	Muestra muestraMock;
	EstadoMuestra estadoMock;
	Ubicacion ubicacion;
	File fotoMuestra;
	
	@Before
	public void setUp() {
		user = new Usuario();
		muestraMock = mock(Muestra.class);
		when(muestraMock.getEstadoDeLaMuestra()).thenReturn(estadoMock);
		
		estadoMock = mock(EstadoMuestra.class);
		when(estadoMock.getEstado()).thenReturn("Normal");
		
		ubicacion = mock(Ubicacion.class);
		
		fotoMuestra = mock(File.class);
	}
	@Test
	public void getter() {
		assertEquals(Arrays.asList(),user.getMuestrasEnviadas()); 
		assertEquals(Arrays.asList(),user.getMuestrasOpinadas());
	}
	
	
	@Test
	public void condicionExperto() {
		assertFalse(user.cumpleCondicionDeExperto());
	} 
	
	@Test
	public void nivelDeUsuario() {
		assertEquals("Basico",user.nivelDeUsuario());
	} 
	
	@Test
	public void enviarUnaMuestra() {
		user.enviarUnaMuestra(fotoMuestra, ubicacion);
		assertFalse(user.getMuestrasEnviadas().isEmpty());
	}
	
}
