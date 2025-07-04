package unq.cazaDeVinchucas.modelo.Muestra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;



import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoMuestra;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;


public class EstadoMuestraTest {
	
	EstadoMuestra estadoMMock;
	EstadoMuestra estadoMMock2;
	Muestra muestraMock;
	
	@Before
	public void setUp() {
		muestraMock = mock(Muestra.class);
		
		estadoMMock2 = mock(EstadoMuestra.class);
		estadoMMock = mock(EstadoMuestra.class);
		when(estadoMMock.getMuestra()).thenReturn(muestraMock);
		when(estadoMMock.condicionDeCambioDeEstado()).thenReturn(true);
		when(estadoMMock.siguienteEstado()).thenReturn(estadoMMock2);
		
		doAnswer(invocation -> {
			estadoMMock.getMuestra().setEstadoDeLaMuestra(estadoMMock.siguienteEstado());
			return null; 
			}).when(estadoMMock).cambiarEstado();
		
		doAnswer(invocation -> {
			if(estadoMMock.condicionDeCambioDeEstado()) {
				muestraMock.setEstadoDeLaMuestra(estadoMMock2);
			}
			return null;
			}).when(estadoMMock).corroborarEstado();
	}
	
	@Test
	public void agregarOpinion() {
		assertEquals(muestraMock, estadoMMock.getMuestra());
	}	
	
	@Test
	public void cambiarEstado() {
		estadoMMock.cambiarEstado();
		
		verify(muestraMock).setEstadoDeLaMuestra(estadoMMock2);
		verify(estadoMMock).siguienteEstado(); 
		verify(estadoMMock).getMuestra();
	}
	
	@Test 
	public void corroborarEstadoTrue() { 
		estadoMMock.corroborarEstado();
		
		verify(muestraMock).setEstadoDeLaMuestra(estadoMMock2);
	}
	
	@Test
	public void corroborarEstadoFalse() {
		when(estadoMMock.condicionDeCambioDeEstado()).thenReturn(false);
		estadoMMock.corroborarEstado();
		
		verify(muestraMock, never()).setEstadoDeLaMuestra(estadoMMock);
	}
}
