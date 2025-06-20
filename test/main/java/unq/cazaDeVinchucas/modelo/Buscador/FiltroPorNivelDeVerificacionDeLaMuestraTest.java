package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;



class FiltroPorNivelDeVerificacionDeLaMuestraTest {
	Usuario usuarioMock;
	File fileMock;
	Ubicacion ubicacionMock;
	
	Opinion opinionExpertaA;
	Opinion opinionExpertaB;
	Opinion opinionNormalA;
	
	Muestra muestra;
	
	
	FiltroPorNivelDeVerificacionDeLaMuestra filtroPorNivelDeVerificacion;


	
	@BeforeEach
	public void setUp() {
		
		usuarioMock = mock(Usuario.class);
		fileMock = mock(File.class);
		ubicacionMock  = mock(Ubicacion.class);
		
		opinionExpertaA = mock(Opinion.class);
		when(opinionExpertaA.getTipo()).thenReturn("Experto");
		when(opinionExpertaA.getOpinion()).thenReturn("Vinchuca");
		
		opinionExpertaB = mock(Opinion.class);
		when(opinionExpertaB.getTipo()).thenReturn("Experto");
		when(opinionExpertaB.getOpinion()).thenReturn("Vinchuca");
		
		opinionNormalA  = mock(Opinion.class);
		when(opinionNormalA.getTipo()).thenReturn("Experto");
		when(opinionNormalA.getOpinion()).thenReturn("Chinche");
				
		muestra = new Muestra(usuarioMock, fileMock, ubicacionMock);

		//Buscador
		filtroPorNivelDeVerificacion= new FiltroPorNivelDeVerificacionDeLaMuestra();
		
	}
		
	
	@Test
	public void filtroPorNivelDeVerificacion() {
		filtroPorNivelDeVerificacion.setNivelDeVerificacion("Verificada");
		assertFalse(filtroPorNivelDeVerificacion.cumpleCriterio(muestra));
		
		muestra.agregarOpinion(opinionNormalA);
		assertFalse(filtroPorNivelDeVerificacion.cumpleCriterio(muestra));
		
		
		muestra.agregarOpinion(opinionExpertaA);
		assertFalse(filtroPorNivelDeVerificacion.cumpleCriterio(muestra));
		
		muestra.agregarOpinion(opinionExpertaB);
		assertTrue(filtroPorNivelDeVerificacion.cumpleCriterio(muestra));
	}

}
