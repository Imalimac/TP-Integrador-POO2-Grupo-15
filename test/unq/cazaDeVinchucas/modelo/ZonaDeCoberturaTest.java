package unq.cazaDeVinchucas.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;


class ZonaDeCoberturaTest {
	ManagerDeEventos manager;
	ZonaDeCobertura zonaMock;

	protected Muestra muestraMock;
	
	protected Ubicacion ubicacion1;
	protected Ubicacion ubicacion2;
	protected Ubicacion ubicacion3;
	
	protected ZonaDeCobertura zona1;
	protected ZonaDeCobertura zona2;
	protected ZonaDeCobertura zona3;

	@BeforeEach
	public void setUp() {
		manager = ManagerDeEventos.getInstancia();
		
		ubicacion1 = new Ubicacion(34,58);
		ubicacion2 = new Ubicacion(34,58);
		ubicacion3 = new Ubicacion(24,64);
		
		muestraMock = mock(Muestra.class);
		when(muestraMock.getUbicacionDeLaMuestra()).thenReturn(ubicacion1);
		manager.agregarMuestra(muestraMock);
			
		zona1 = new ZonaDeCobertura(ubicacion1, 50, "Quilmes");
		zona2 = new ZonaDeCobertura(ubicacion2, 3, "Bernal");
		zona3 = new ZonaDeCobertura(ubicacion3, 50, "Salta");
	}
	/*
	@Test
	public void creacionDeZona() {
		assertTrue(manager.getZonasDeCobertura().contains(zona1));
		assertTrue(manager.getZonasDeCobertura().contains(zona2));
	}
	*/
	@Test
	public void muestrasReportadas() {
		assertFalse(zona1.getMuestrasDeLaZona().contains(muestraMock));
	}
	
	@Test
	public void solapamiestoDeZonas() {
		assertTrue(zona1.seSolapaCon(zona2));
		assertFalse(zona1.seSolapaCon(zona3));
	}
	
	@Test
	public void getRadioYgetNombre() {
		assertEquals(zona1.getRadio(), 50);
		assertEquals(zona1.getNombre(), "Quilmes");
	}
	
	@Test
	public void contieneUbicacion() {
		assertTrue(zona1.contieneUbicacion(ubicacion1));
		assertFalse(zona1.contieneUbicacion(ubicacion3));
	}
	/*
	@Test
	public void contieneMuestra() {
		assertFalse(zona1.contieneMuestra(muestraMock));
	} 
	*/
	@Test
	public void zonasSolapadas() {
		assertEquals(Arrays.asList(zona2), zona1.zonasSolapadas(Arrays.asList(zona2,zona3)));
	}

}
