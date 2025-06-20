package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;


class FiltroPorFechaDeUltimaVotacionDeLaMuestraTest {

	Usuario usuarioMock;
	File fileMock;
	Ubicacion ubicacionMock;
	
	Opinion opinion;
	Opinion opinion2;
	
	Muestra muestra;
	
	LocalDate primeroDeOctubreDe2023;
	LocalDate primeroDeOctubreDe2024;
	
	FiltroPorFechaDeUltimaVotacionDeLaMuestra filtroPorUltimaVotacion;
	
	
	
	@BeforeEach
	public void setUp() {
		usuarioMock = mock(Usuario.class);
		when(usuarioMock.nivelDeUsuario()).thenReturn("Basico");
		fileMock = mock(File.class);
		ubicacionMock  = mock(Ubicacion.class);
		
		primeroDeOctubreDe2024 = LocalDate.of(2023, 10, 01);
		
		muestra = new Muestra(usuarioMock, fileMock, ubicacionMock);
		
		opinion = new Opinion(usuarioMock, muestra, "Vinchuca");
		opinion2 = new Opinion(usuarioMock, muestra, "Vinchuca");
								
		filtroPorUltimaVotacion = new FiltroPorFechaDeUltimaVotacionDeLaMuestra();

	}
	

	@Test
	void testFiltroFalse() {
		filtroPorUltimaVotacion.setFecha(this.primeroDeOctubreDe2024);
		muestra.agregarOpinion(opinion);
		assertFalse(filtroPorUltimaVotacion.cumpleCriterio(muestra));
		
	}
	
	@Test
	void testFiltroTrue() {
		filtroPorUltimaVotacion.setFecha(LocalDate.now());
		
		muestra.agregarOpinion(opinion);
		muestra.agregarOpinion(opinion2);
				
		assertTrue(filtroPorUltimaVotacion.cumpleCriterio(muestra));
		
		

	}

}
