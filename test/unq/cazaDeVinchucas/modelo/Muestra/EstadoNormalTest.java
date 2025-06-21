package unq.cazaDeVinchucas.modelo.Muestra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoMuestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoNormal;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;

public class EstadoNormalTest {
	
	EstadoNormal estadoN;
	Muestra muestraMock;
	Opinion opinionMock;
	List<String> listaStringMuestra;
	List<Opinion> listaOpinionesMuestra;
	
	@Before
	public void setUp() {
		listaStringMuestra = Arrays.asList("Vinchuca");
		listaOpinionesMuestra = Arrays.asList(opinionMock);
		
		opinionMock = mock(Opinion.class);
		muestraMock = mock(Muestra.class);
		when(muestraMock.getListaDeResultadosDeOpinionDeLaMuestra()).thenReturn(listaStringMuestra);
		when(muestraMock.getListaOpinionesExpertasDeLaMuestra()).thenReturn(listaOpinionesMuestra);
		estadoN = new EstadoNormal(muestraMock);
	}
	
	@Test
	public void resultadoFinalUnElemento() {
		assertEquals("Vinchuca", estadoN.resultadoFinal());
	} 
	
	@Test
	public void resultadoFinalNoDefinido() {
		listaStringMuestra = Arrays.asList("Vinchuca", "Imagen poco clara");
		when(muestraMock.getListaDeResultadosDeOpinionDeLaMuestra()).thenReturn(listaStringMuestra);
		
		assertEquals("No definido.", estadoN.resultadoFinal());
	}
	
	@Test
	public void condicionDeCambioDeEstadoTrue() {
		assertTrue(estadoN.condicionDeCambioDeEstado());
	}
	
	@Test
	public void condicionDeCambioDeEstadoFalse() {
		listaOpinionesMuestra = new ArrayList<Opinion>();
		when(muestraMock.getListaOpinionesExpertasDeLaMuestra()).thenReturn(listaOpinionesMuestra);
		
		assertFalse(estadoN.condicionDeCambioDeEstado());
	}
	
	@Test
	public void getEstado() {
		assertEquals("Normal", estadoN.getEstado());
	}
	
	@Test
	public void cambiarEstadoESTADOMUESTRA() {
		estadoN.cambiarEstado();
		when(muestraMock.getEstadoDeLaMuestra()).thenReturn(estadoN);
		
		assertEquals(estadoN, muestraMock.getEstadoDeLaMuestra());	
	}
	
	@Test
	public void agregarO() {
		estadoN.agregarO(opinionMock);

		verify(muestraMock).agregarO(opinionMock);
	}
	
	@Test
	public void siguienteEstado() {
		EstadoMuestra estadoNuevo = estadoN.siguienteEstado();
		assertEquals(estadoNuevo, estadoNuevo);
	}
}
