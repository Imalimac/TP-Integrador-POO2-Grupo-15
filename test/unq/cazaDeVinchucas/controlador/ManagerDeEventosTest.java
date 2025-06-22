package unq.cazaDeVinchucas.controlador;


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

	    @BeforeEach
	    public void setUp() {
	        manager = new ManagerDeEventos();
	        muestraMock = mock(Muestra.class);
	    }

	    @Test
	    public void seAgregaUnaMuestraAlBancoDeMuestras() {
	        manager.agregarMuestra(muestraMock);
	        
	        List<Muestra> muestras = manager.getBancoDeMuestras();


	        assertTrue(muestras.contains(muestraMock), "La muestra debería estar en el banco de muestras");
	    }
	}


