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




class FiltroOrTest {
	
	Usuario usuarioMock;
	File fileMock;
	Ubicacion ubicacionMock;
	
	Opinion opinionExpertaA;
	Opinion opinionExpertaB;
	Opinion opinionNormalA;
	
	Muestra muestra;
	
	FiltroPorTipoDeInsectoDeLaMuestra filtroPorTipoDeInsecto;
	FiltroPorNivelDeVerificacionDeLaMuestra filtroPorNivelDeVerificacion;
	FiltroOr filtroOr;
	
	
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

		filtroPorNivelDeVerificacion= new FiltroPorNivelDeVerificacionDeLaMuestra();
		filtroPorTipoDeInsecto= new FiltroPorTipoDeInsectoDeLaMuestra();
		filtroOr = new FiltroOr();
	}
	
	@Test
	void testVerdaderoAmbas() {
		filtroPorNivelDeVerificacion.setNivelDeVerificacion("Verificada");
		filtroPorTipoDeInsecto.setTipoDeInsecto("Vinchuca");
		muestra.agregarOpinion(opinionNormalA);
		muestra.agregarOpinion(opinionExpertaA);
		muestra.agregarOpinion(opinionExpertaB);
		

		filtroOr.agregarCriterio(filtroPorNivelDeVerificacion);
		filtroOr.agregarCriterio(filtroPorTipoDeInsecto);
		
		assertTrue(filtroOr.cumpleCriterio(muestra));
	}

	@Test
	void testVerdaderoUno() {
		filtroPorNivelDeVerificacion.setNivelDeVerificacion("Verificada");
		filtroPorTipoDeInsecto.setTipoDeInsecto("Chinche");
		muestra.agregarOpinion(opinionNormalA);
		muestra.agregarOpinion(opinionExpertaA);
		muestra.agregarOpinion(opinionExpertaB);
		

		filtroOr.agregarCriterio(filtroPorNivelDeVerificacion);
		filtroOr.agregarCriterio(filtroPorTipoDeInsecto);
		
		assertTrue(filtroOr.cumpleCriterio(muestra));
	}
	
	@Test
	void testFalso() {
		filtroPorNivelDeVerificacion.setNivelDeVerificacion("Votada");
		filtroPorTipoDeInsecto.setTipoDeInsecto("Chinche");
		muestra.agregarOpinion(opinionNormalA);
		muestra.agregarOpinion(opinionExpertaA);
		muestra.agregarOpinion(opinionExpertaB);
		

		filtroOr.agregarCriterio(filtroPorNivelDeVerificacion);
		filtroOr.agregarCriterio(filtroPorTipoDeInsecto);
		
		assertFalse(filtroOr.cumpleCriterio(muestra));
	}
	
}