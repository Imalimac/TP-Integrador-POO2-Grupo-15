package unq.cazaDeVinchucas.controlador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
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

		Muestra muestra;

		private Organizacion organizacion;
		private Organizacion organizacionMock;

		private ZonaDeCobertura zonaMock;

		private Ubicacion ubicacion1;

		private EstadoConOpinionExperta estadoExperto;

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
	
		muestra = new Muestra(usuarioMock, fileMock, ubicacionMock);
		muestra.setEstadoDeLaMuestra(estadoExperto);        
   	
		organizacion = new Organizacion(ubicacion1, "ONG", 2, fun1, fun2);
		organizacionMock = mock(Organizacion.class);
    
		zonaMock = mock(ZonaDeCobertura.class);
		when(zonaMock.contieneMuestra(muestra)).thenReturn(true);
    }
 
	@Test
	public void suscribirYDesuscribir() {
		// suscribir
		organizacion.suscribirseA(zonaMock);
		assertFalse(manager.getSuscriptores().isEmpty());
		assertEquals(manager.getSuscriptores().values().iterator().next(), zonaMock);
		assertEquals(manager.getSuscriptores().keySet().iterator().next(), organizacion);

		// desuscribir
		organizacion.desuscribirseA(zonaMock);
		assertTrue(manager.getSuscriptores().isEmpty());

	}

	@Test
    public void notificarNuevaValidacionDeMuestra() {
    	manager.suscribir(organizacionMock, zonaMock);
    	manager.notificarNuevaValidacionDeMuestra(muestra);
    	
    	verify(organizacionMock).funcionalidadValidacionDeMuestra(zonaMock,muestra);
    } 

	@Test
	public void notificarNuevaMuestra() {
    	manager.suscribir(organizacionMock, zonaMock);
    	manager.notificarNuevaMuestra(muestra);
    	
    	verify(organizacionMock).funcionalidadNuevaMuestra(zonaMock,muestra);
	}

}
