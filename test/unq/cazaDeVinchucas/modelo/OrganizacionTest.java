package unq.cazaDeVinchucas.modelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.Organizacion;
import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public class OrganizacionTest {
	
	Ubicacion ubicacion1;
	Ubicacion ubicacion2;
	
	FuncionalidadExterna fun1;
	FuncionalidadExterna fun2;
	
	ZonaDeCobertura zonaMock;
	
	Organizacion orga;
	ManagerDeEventos manager;
	
	Muestra muestra;

	@BeforeEach
	public void setUp() {
		zonaMock = mock(ZonaDeCobertura.class);
		
		fun1 = mock(FuncionalidadExterna.class);
		fun2 = mock(FuncionalidadExterna.class);
		
		ubicacion1 = mock(Ubicacion.class);
		ubicacion2 = mock(Ubicacion.class);
		
		muestra = mock(Muestra.class);
		
		orga = new Organizacion(ubicacion1, "gubernamental", 20, fun1, fun2);
		manager = ManagerDeEventos.getInstancia();
	}

	@Test
	void gettersYSetters() {
		orga.setUbicacionDeLaOrganizacion(ubicacion2);
		assertEquals(ubicacion2, orga.getUbicacionDeLaOrganizacion());
		orga.setTipoDeOrganizacion("Salud");
		assertEquals("Salud", orga.getTipoDeOrganizacion());
		orga.setCantidadDePersonal(30);
		assertEquals(30, orga.getCantidadDePersonal());
	}
	
	@Test
	void funcionalidadNuevaMuestra() {
		orga.funcionalidadNuevaMuestra(zonaMock, muestra);
		verify(fun1).nuevoEvento(orga, zonaMock, muestra);
	}
	
	@Test
	void funcionalidadValidacionDeMuestra() {
		orga.funcionalidadValidacionDeMuestra(zonaMock, muestra);
		verify(fun2).nuevoEvento(orga, zonaMock, muestra);
	}
}
