package unq.cazaDeVinchucas.modelo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;
import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.File;
import java.util.Arrays;


class ZonaDeCoberturaTest {
	private Usuario usuarioMock;
	private File fileMock;

	private Muestra muestra;
	
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	private ZonaDeCobertura zona3;
	
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;

	@BeforeEach
	public void setUp() {
		usuarioMock = mock(Usuario.class);
		fileMock = mock(File.class);
		
		ubicacion1 = new Ubicacion(34,58);
		ubicacion2 = new Ubicacion(34,58);
		ubicacion3 = new Ubicacion(24,64);
		
		muestra = new Muestra(usuarioMock, fileMock, ubicacion1);
			
		zona1 = new ZonaDeCobertura(ubicacion1, 50, "Quilmes");
		zona2 = new ZonaDeCobertura(ubicacion2, 3, "Bernal");
		zona3 = new ZonaDeCobertura(ubicacion3, 50, "Salta");
	
	}

	@Test
	void creacionDeZona() {
		assertTrue(ManagerDeEventos.getInstancia().getZonasDeCobertura().contains(zona1));
		assertTrue(ManagerDeEventos.getInstancia().getZonasDeCobertura().contains(zona2));
	}
	
	@Test
	void muestrasReportadas() {
		assertTrue(zona1.getMuestrasDeLaZona().contains(muestra));
	}
	
	@Test
	void solapamiestoDeZonas() {
		assertTrue(zona1.seSolapaCon(zona2));
		assertFalse(zona1.seSolapaCon(zona3));
	}
	
	@Test
	void getRadioYgetNombre() {
		assertEquals(zona1.getRadio(), 50);
		assertEquals(zona1.getNombre(), "Quilmes");
	}
	
	@Test
	void contieneUbicacion() {
		assertTrue(zona1.contieneUbicacion(ubicacion1));
		assertFalse(zona1.contieneUbicacion(ubicacion3));
	}
	
	@Test
	void contieneMuestra() {
		assertTrue(zona1.contieneMuestra(muestra));
	} 
	
	@Test
	void zonasSolapadas() {
		assertEquals(Arrays.asList(zona2), zona1.zonasSolapadas(Arrays.asList(zona2,zona3)));
	}

}
