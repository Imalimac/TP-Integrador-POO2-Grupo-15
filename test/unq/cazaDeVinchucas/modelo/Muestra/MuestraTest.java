package unq.cazaDeVinchucas.modelo.Muestra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoConOpinionExperta;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoNormal;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class MuestraTest {
	
	Opinion opinionMock;
	Opinion opinion2Mock;
	
	Usuario usuarioMock;
	File fileMock;
	Ubicacion ubicacionMock;
	EstadoNormal eNormalMock;
	EstadoConOpinionExperta eExpertoMock;
	
	Muestra muestra;
	List<String> listaOpinionesString;
	List<Opinion> listaOpiniones;
	
	@Before
	public void setUp() {
		opinionMock = mock(Opinion.class);
		when(opinionMock.getOpinion()).thenReturn("Vinchuca");
		when(opinionMock.getTipo()).thenReturn("Experto");
		
		opinion2Mock = mock(Opinion.class);
		when(opinion2Mock.getOpinion()).thenReturn("Vinchuca");
		when(opinion2Mock.getTipo()).thenReturn("Normal");
		
		usuarioMock = mock(Usuario.class);
		fileMock = mock(File.class);
		ubicacionMock  = mock(Ubicacion.class);
		eNormalMock = mock(EstadoNormal.class);
		eExpertoMock = mock(EstadoConOpinionExperta.class);
		when(eNormalMock.resultadoFinal()).thenReturn("En Proceso");
		
		muestra = new Muestra(usuarioMock, fileMock, ubicacionMock, eNormalMock);
		
		listaOpinionesString = Arrays.asList("Vinchuca", "Vinchuca");
		
		listaOpiniones = Arrays.asList(opinionMock);
	}
	
	@Test
	public void agregarOpinion() {
		muestra.agregarOpinion(opinionMock);
		
		verify(eNormalMock).corroborarEstado();
		verify(eNormalMock).agregarO(opinionMock);
	}
	
	@Test
	public void agregarO() {
		muestra.agregarO(opinionMock);
		
		assertEquals(muestra.getOpinionesDeLaMuestra().getFirst(), opinionMock);
	}
	
	@Test
	public void settersYGetters() {
		assertEquals(fileMock, muestra.getFotoDeLaMuestra());
		assertEquals(eNormalMock, muestra.getEstadoDeLaMuestra());
		assertEquals(ubicacionMock, muestra.getUbicacionDeLaMuestra());
		
		muestra.setEstadoDeLaMuestra(eExpertoMock);
		assertEquals(eExpertoMock, muestra.getEstadoDeLaMuestra());
	}
	
	@Test
	public void listaResultados() {
		muestra.agregarO(opinionMock);
		muestra.agregarO(opinion2Mock);
		
		assertEquals(listaOpinionesString, muestra.getListaDeResultadosDeOpinionDeLaMuestra());
	}
	
	@Test
	public void listaResultadosExpertos() {
		muestra.agregarO(opinionMock);
		muestra.agregarO(opinion2Mock);
		listaOpinionesString = Arrays.asList("Vinchuca");
		
		assertEquals(listaOpinionesString, muestra.getListaDeResultadosExpertosDeLaMuestra());
	}
	
	@Test
	public void listaOpinionesExpertas() {
		muestra.agregarO(opinionMock);
		muestra.agregarO(opinion2Mock);
		
		assertEquals(listaOpiniones, muestra.getListaOpinionesExpertasDeLaMuestra());
	}
	
	@Test
	public void resultadoFinal() {
		muestra.setEstadoDeLaMuestra(eNormalMock);  
		
		assertEquals("En Proceso", muestra.resultadoFinal());
	}	
}
