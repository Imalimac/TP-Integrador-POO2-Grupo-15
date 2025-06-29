package unq.cazaDeVinchucas.controlador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.Organizacion;
import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoConOpinionExperta;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;
import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public class ManagerDeEventosTest {

	private ManagerDeEventos manager;
	
	FuncionalidadExterna fun1;
	FuncionalidadExterna fun2;

	Usuario usuarioMock;
	File fileMock;
	Ubicacion ubicacionMock;

	Opinion opinionExpertaA;
	Opinion opinionExpertaB;
	Opinion opinionNormalA;

	Muestra muestraMock;

	private Organizacion organizacion;
	private Organizacion organizacionMock;

	private ZonaDeCobertura zonaMock;

	private Ubicacion ubicacion1;

	private EstadoConOpinionExperta estadoExperto;

	List<ZonaDeCobertura> listaZona;
	@BeforeEach
	public void setUp() {
		manager = ManagerDeEventos.getInstancia();
		
		fun1 = mock(FuncionalidadExterna.class);
		fun2 = mock(FuncionalidadExterna.class);
	    	
		usuarioMock = mock(Usuario.class);
		fileMock = mock(File.class);
		ubicacionMock  = mock(Ubicacion.class);
		opinionExpertaA = mock(Opinion.class);
			
		estadoExperto = mock(EstadoConOpinionExperta.class);
		when(estadoExperto.condicionDeCambioDeEstado()).thenReturn(true);
		
		muestraMock = mock(Muestra.class);
		when(muestraMock.getEstadoDeLaMuestra()).thenReturn(estadoExperto);
		
		zonaMock = mock(ZonaDeCobertura.class);
		when(zonaMock.contieneMuestra(muestraMock)).thenReturn(true);
		manager.agregarZonaDeCoberturaNueva(zonaMock);
   	
		listaZona = Arrays.asList(zonaMock);
		
		organizacion = new Organizacion(ubicacion1, "ONG", 2, fun1, fun2);
		organizacionMock = mock(Organizacion.class);
		when(organizacionMock.getSuscripciones()).thenReturn(listaZona);
    }
 
	@Test
	public void suscribirYDesuscribir() {
		// suscribir
		manager.suscribir(organizacion, zonaMock);
		assertFalse(manager.getSuscriptores().isEmpty());
		assertEquals(manager.getSuscriptores().getFirst(), organizacion);

		// desuscribir
		manager.desuscribir(organizacion, zonaMock);
		assertTrue(manager.getSuscriptores().isEmpty());

	}

	@Test
    public void notificarNuevaValidacionDeMuestra() {
    	manager.suscribir(organizacionMock, zonaMock);
    	manager.notificarNuevaValidacionDeMuestra(Arrays.asList(zonaMock), muestraMock);
    	
    	verify(organizacionMock).funcionalidadValidacionDeMuestra(zonaMock, muestraMock);
    } 

	@Test
	public void notificarNuevaMuestra() {
    	manager.suscribir(organizacionMock, zonaMock);
    	manager.notificarNuevaMuestra(Arrays.asList(zonaMock), muestraMock);
    	
    	verify(organizacionMock).funcionalidadNuevaMuestra(zonaMock, muestraMock);
	}

}
