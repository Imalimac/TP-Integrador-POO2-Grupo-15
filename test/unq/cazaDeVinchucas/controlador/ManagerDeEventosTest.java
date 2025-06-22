package unq.cazaDeVinchucas.controlador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
	
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import static org.mockito.Mockito.mock;

	import java.util.List;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
	import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public class ManagerDeEventosTest {

	    private ManagerDeEventos manager;
	    private Muestra muestraMock;
	    
	    private Muestra muestra1;
	    private Muestra muestra2;
	    private Muestra muestra3;
	    private Muestra muestraInexistente;

	    @BeforeEach
	    public void setUp() {
	        manager = new ManagerDeEventos();
	        muestraMock = mock(Muestra.class);
	        muestra1 = mock(Muestra.class);
	        muestra2 = mock(Muestra.class);
	        muestra3 = mock(Muestra.class);
	        muestraInexistente = mock(Muestra.class);
	    }

	    @Test
	    public void seAgregaUnaMuestraAlBancoDeMuestras() {
	        manager.agregarMuestra(muestraMock);
	        
	        List<Muestra> muestras = manager.getBancoDeMuestras();


	        assertTrue(muestras.contains(muestraMock), "La muestra debería estar en el banco de muestras");
	    }
	    @Test
	    public void seEliminaUnaMuestraDelBancoDeMuestras() {
	        
	    	manager.agregarMuestra(muestraMock);
	        manager.eliminarMuestra(muestraMock);

	      
	        List<Muestra> muestras = manager.getBancoDeMuestras();
	        assertFalse(muestras.contains(muestraMock), "La muestra debería haber sido eliminada del banco");
	    }
	    @Test
	    public void seAgreganVariasMuestrasAlBanco() {
	        manager.agregarMuestra(muestra1);
	        manager.agregarMuestra(muestra2);
	        manager.agregarMuestra(muestra3);

	        List<Muestra> muestras = manager.getBancoDeMuestras();

	        assertTrue(muestras.contains(muestra1));
	        assertTrue(muestras.contains(muestra2));
	        assertTrue(muestras.contains(muestra3));
	        assertEquals(3, muestras.size());
	    }
	    @Test
	    public void seEliminaUnaMuestraYLasDemasPermanecen() {
	        manager.agregarMuestra(muestra1);
	        manager.agregarMuestra(muestra2);
	        manager.agregarMuestra(muestra3);

	        manager.eliminarMuestra(muestra2);

	        List<Muestra> muestras = manager.getBancoDeMuestras();
	        assertFalse(muestras.contains(muestra2));
	        assertTrue(muestras.contains(muestra1));
	        assertTrue(muestras.contains(muestra3));
	        assertEquals(2, muestras.size());
	    }

	    @Test
	    public void eliminarMuestraQueNoExisteNoAfectaElBanco() {
	        manager.agregarMuestra(muestra1);
	        manager.agregarMuestra(muestra2);

	        manager.eliminarMuestra(muestraInexistente);

	        List<Muestra> muestras = manager.getBancoDeMuestras();
	        assertEquals(2, muestras.size());
	        assertTrue(muestras.contains(muestra1));
	        assertTrue(muestras.contains(muestra2));
	    }
	    @Test
	    public void agregarLaMismaMuestraDosVecesYEliminarUna() {
	        manager.agregarMuestra(muestra1);
	        manager.agregarMuestra(muestra1); // misma instancia dos veces

	        manager.eliminarMuestra(muestra1); // solo elimina una

	        List<Muestra> muestras = manager.getBancoDeMuestras();
	        assertEquals(1, muestras.size());
	        assertTrue(muestras.contains(muestra1));
	    }
	}

	



