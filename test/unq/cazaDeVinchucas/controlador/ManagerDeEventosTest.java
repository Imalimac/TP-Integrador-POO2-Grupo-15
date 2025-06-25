package unq.cazaDeVinchucas.controlador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
	
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.ONG;
import main.java.unq.cazaDeVinchucas.modelo.Organizacion;
import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoConOpinionExperta;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class ManagerDeEventosTest {

	    private ManagerDeEventos manager;
	    
	    Usuario usuarioMock;
		File fileMock;
		Ubicacion ubicacionMock;
		
		Opinion opinionExpertaA;
		Opinion opinionExpertaB;
		Opinion opinionNormalA;
		
		Muestra muestra;


	    private Organizacion organizacion;
	    
	    private ZonaDeCobertura zona;
	    
	    private Ubicacion ubicacion1;

	    private EstadoConOpinionExperta estadoExperto;
	    
	    
	    @BeforeEach
	    public void setUp() {
	    	manager = ManagerDeEventos.getInstancia();
	    	
	    	usuarioMock = mock(Usuario.class);
			fileMock = mock(File.class);
			ubicacionMock  = mock(Ubicacion.class);
			opinionExpertaA = mock(Opinion.class);
			
			estadoExperto = mock(EstadoConOpinionExperta.class);
			when(estadoExperto.condicionDeCambioDeEstado()).thenReturn(true);
			
			muestra = new Muestra(usuarioMock, fileMock, ubicacionMock);
	       	muestra.setEstadoDeLaMuestra(estadoExperto);        
	       	
	       	organizacion = new ONG(ubicacion1, "ONG", 2);
	        
	        zona = mock(ZonaDeCobertura.class);
	        
	        
	    }

	    @Test
	    public void suscribirYDesuscribir() {
	    	//suscribir
	    	organizacion.suscribirseA(zona);
	    	assertFalse(manager.getSuscriptores().isEmpty());
	    	assertEquals (manager.getSuscriptores().values().iterator().next(), zona);
	    	assertEquals (manager.getSuscriptores().keySet().iterator().next(), organizacion);
	    	
	    	//desuscribir
	    	organizacion.desuscribirseA(zona);
	    	assertTrue(manager.getSuscriptores().isEmpty());
	    	
	    }

	    @Test
	    public void notificarNuevaValidacionDeMuestra() {
	    	assertEquals(muestra.getEstadoDeLaMuestra(), estadoExperto);
	    	muestra.agregarO(opinionExpertaA);
	    }
	    
	    @Test
	    public void notificarNuevaMuestra() {

	    
	    }

}

	



