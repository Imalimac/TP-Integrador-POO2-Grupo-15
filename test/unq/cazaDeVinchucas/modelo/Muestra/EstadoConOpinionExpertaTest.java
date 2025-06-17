package unq.cazaDeVinchucas.modelo.Muestra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoConOpinionExperta;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoMuestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;

public class EstadoConOpinionExpertaTest {
	Muestra muestraMock;
	EstadoConOpinionExperta estadoC;
	List<String> resultadosString;
	Opinion opinionMock;
	
	@Before
	public void setUp() {
		resultadosString = Arrays.asList("Vinchuca", "Vinchuca");
		opinionMock = mock(Opinion.class);
		when(opinionMock.getTipo()).thenReturn("Experto");
		muestraMock = mock(Muestra.class);
		when(muestraMock.getListaDeResultadosExpertosDeLaMuestra()).thenReturn(resultadosString);
		
		
		estadoC = new EstadoConOpinionExperta(muestraMock);
	}
	
	@Test
	public void getEstado() {
		assertEquals("ConOpinionExperta", estadoC.getEstado());
	}
	
	@Test
	public void resultadoFinalUnElemento() {
		assertEquals("Vinchuca", estadoC.resultadoFinal());
	}
	
	@Test
	public void resultadoFinalNoDefinido() {
		resultadosString = Arrays.asList("Vinchuca", "Imagen poco clara");
		when(muestraMock.getListaDeResultadosExpertosDeLaMuestra()).thenReturn(resultadosString);
		
		assertEquals("No definido.", estadoC.resultadoFinal());
	}
	
	@Test
	public void siguienteEstado() {
		EstadoMuestra estadoNuevo = estadoC.siguienteEstado();
		assertEquals(estadoNuevo, estadoNuevo);
	}
	
	@Test
	public void agregarOTrue() {
		estadoC.agregarO(opinionMock);
		verify(muestraMock).agregarO(opinionMock);
	}
	
	@Test
	public void agregarOFalse() {
		when(opinionMock.getTipo()).thenReturn("Normal");
		verify(muestraMock, never()).agregarO(opinionMock);
	}
	
	@Test
	public void condicionDeCambioDeEstadoTrue() {
		assertTrue(estadoC.condicionDeCambioDeEstado());
	}
	
	@Test
	public void condicionDeCambioDeEstadoFalse() {
		resultadosString = Arrays.asList("Vinchuca", "Imagen poco clara");
		when(muestraMock.getListaDeResultadosExpertosDeLaMuestra()).thenReturn(resultadosString);
		
		assertFalse(estadoC.condicionDeCambioDeEstado());
	}
}
