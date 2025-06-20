package unq.cazaDeVinchucas.modelo.Muestra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoVerificada;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;


public class EstadoVerificadaTest {
	
	Muestra muestraMock;
	EstadoVerificada estadoV;
	List<String> resultadosString;
	
	@Before
	public void setUp() {
		resultadosString = Arrays.asList("Vinchuca", "Vinchuca");
		
		muestraMock = mock(Muestra.class);
		when(muestraMock.getListaDeResultadosExpertosDeLaMuestra()).thenReturn(resultadosString);
		
		estadoV = new EstadoVerificada(muestraMock);
	}
	
	@Test
	public void getEstado() {
		assertEquals("Verificada", estadoV.getEstado());
	}
	
	@Test
	public void condicionDeCambioDeEstado() {
		assertFalse(estadoV.condicionDeCambioDeEstado());
	}
	
	@Test
	public void agregarO() {
		estadoV.agregarO(null);
	}
	
	@Test
	public void siguienteEstado() {
		assertEquals(null, estadoV.siguienteEstado());
	}
	
	@Test
	public void resultadoFinal() {
		assertEquals("Vinchuca", estadoV.resultadoFinal());
	}
}
