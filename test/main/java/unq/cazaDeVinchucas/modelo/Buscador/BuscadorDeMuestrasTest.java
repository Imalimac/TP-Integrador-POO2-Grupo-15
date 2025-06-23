package main.java.unq.cazaDeVinchucas.modelo.Buscador;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoConOpinionExperta;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoNormal;
import main.java.unq.cazaDeVinchucas.modelo.muestra.EstadoVerificada;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class BuscadorDeMuestrasTest {
	LocalDate fechaPrimeroDeOctubre24;
	LocalDate fechaPrimeroDeOctubre23;
	
	Usuario usuarioMock;
	File fileMock;
	Ubicacion ubicacionMock;
	EstadoNormal eNormalMock;
	EstadoConOpinionExperta eExpertoMock;
	EstadoVerificada eVerificadaMock;
			
	Opinion opinionExpertaA;
	Opinion opinionExpertaB;
	Opinion opinionNormalA;
	
	ArrayList<Opinion>opinionesExpertas;
	ArrayList<Opinion>opinionesMixtas;
	
	Muestra muestraVerificada;
	Muestra muestraVotadaA;
	Muestra muestraVotadaB;
	

	
	BuscadorDeMuestras buscador;
	
	FiltroAnd filtroAnd;
	FiltroOr filtroOr;
	FiltroPorFechaDeCreacionDeLaMuestra filtroPorCreacion;
	FiltroPorNivelDeVerificacionDeLaMuestra filtroPorNivelDeVerificacion;
	FiltroPorTipoDeInsectoDeLaMuestra filtroPorTipoDeInsecto;
	
	List<Muestra> listaDeMuestrasA;
	List<Muestra> listaDeMuestrasB;
	
	
	@BeforeEach
	public void setUp() {
		fechaPrimeroDeOctubre24 = LocalDate.of(2024, 10, 01);
		fechaPrimeroDeOctubre23 = LocalDate.of(2023, 10, 01);
		
		usuarioMock = mock(Usuario.class);
		fileMock = mock(File.class);
		ubicacionMock  = mock(Ubicacion.class);
		eNormalMock  = mock(EstadoNormal.class); 
		eExpertoMock = mock(EstadoConOpinionExperta.class); 
		eVerificadaMock = mock(EstadoVerificada.class); 
		
		opinionExpertaA = mock(Opinion.class);
		when(opinionExpertaA.getFecha()).thenReturn(fechaPrimeroDeOctubre23);
		when(opinionExpertaA.getTipo()).thenReturn("Experto");
		when(opinionExpertaA.getOpinion()).thenReturn("Vinchuca");
		
		opinionExpertaB = mock(Opinion.class);
		when(opinionExpertaB.getFecha()).thenReturn(fechaPrimeroDeOctubre24);
		when(opinionExpertaB.getTipo()).thenReturn("Experto");
		when(opinionExpertaB.getOpinion()).thenReturn("Vinchuca");
		
		opinionNormalA  = mock(Opinion.class);
		when(opinionNormalA.getFecha()).thenReturn(fechaPrimeroDeOctubre23);
		when(opinionNormalA.getTipo()).thenReturn("Experto");
		when(opinionNormalA.getOpinion()).thenReturn("Chinche");
		
		opinionesExpertas= new ArrayList<Opinion>();
		opinionesMixtas = new ArrayList<Opinion>();
		
		opinionesExpertas.add(opinionExpertaA);
		opinionesExpertas.add(opinionExpertaB);
		
		opinionesMixtas.add(opinionNormalA);
		opinionesMixtas.add(opinionExpertaA);
		
		//Muestra verificada
		muestraVerificada = mock(Muestra.class);
		when(muestraVerificada.getFechaDeCreacion()).thenReturn(fechaPrimeroDeOctubre24);
		when(muestraVerificada.getEstadoDeLaMuestra()).thenReturn(eVerificadaMock);
		when(muestraVerificada.getOpinionesDeLaMuestra()).thenReturn(opinionesExpertas);
		when(muestraVerificada.resultadoFinal()).thenReturn("Vinchuca"); 
		
		//Muestra votada
		muestraVotadaA = mock(Muestra.class);
		when(muestraVotadaA.getFechaDeCreacion()).thenReturn(fechaPrimeroDeOctubre23);
		when(muestraVotadaA.getEstadoDeLaMuestra()).thenReturn(eNormalMock);
		when(muestraVotadaA.getOpinionesDeLaMuestra()).thenReturn(opinionesMixtas);
		when(muestraVotadaA.resultadoFinal()).thenReturn("No Definido");
		
		//Muestra votada2
		muestraVotadaB = mock(Muestra.class);
		when(muestraVotadaB.getFechaDeCreacion()).thenReturn(fechaPrimeroDeOctubre24);
		when(muestraVotadaB.getEstadoDeLaMuestra()).thenReturn(eNormalMock);
		when(muestraVotadaB.getOpinionesDeLaMuestra()).thenReturn(opinionesMixtas);
		when(muestraVotadaB.resultadoFinal()).thenReturn("No Definido");
		
				
		//lista de Muestras1
		listaDeMuestrasA = new ArrayList<Muestra>();
		listaDeMuestrasA.add(muestraVerificada);
		listaDeMuestrasA.add(muestraVotadaA);
		
		//lista de Muestras2
		listaDeMuestrasB = new ArrayList<Muestra>();
		listaDeMuestrasB.add(muestraVotadaA);
		listaDeMuestrasB.add(muestraVotadaB);
		
		//Buscador
		
		filtroPorNivelDeVerificacion= new FiltroPorNivelDeVerificacionDeLaMuestra();
		filtroPorTipoDeInsecto= new FiltroPorTipoDeInsectoDeLaMuestra();
		filtroPorCreacion = new FiltroPorFechaDeCreacionDeLaMuestra(); 
		filtroAnd = new FiltroAnd(); 
		filtroOr = new FiltroOr ();
		
		buscador = new BuscadorDeMuestras();
	}	
	
	
	@Test
	public void buscadorSimpleResultadoUnico() {
			
		filtroPorCreacion.setFecha(fechaPrimeroDeOctubre23);
		buscador.setEstrategia(filtroPorCreacion);
		buscador.setMuestras(listaDeMuestrasA);
		
		assertTrue(buscador.filtrar().contains(muestraVotadaA));
	}
	
	@Test
	public void getEstrategia() {
		buscador.setEstrategia(filtroPorCreacion);
		assertEquals(filtroPorCreacion, buscador.estrategia());
	}
	
	@Test
	public void buscadorSimpleResultadoMultiple() {
			 
		filtroPorNivelDeVerificacion.setNivelDeVerificacion("Votada");
		buscador.setEstrategia(filtroPorNivelDeVerificacion);
		buscador.setMuestras(listaDeMuestrasB);
		assertTrue(buscador.filtrar().contains(muestraVotadaA));
		assertTrue(buscador.filtrar().contains(muestraVotadaB));
	}
	
	@Test
	public void buscadorCompuesto() {
		filtroPorCreacion.setFecha(fechaPrimeroDeOctubre23);
		filtroPorNivelDeVerificacion.setNivelDeVerificacion("Votada");
		filtroPorTipoDeInsecto.setTipoDeInsecto("Vinchuca");
		filtroAnd.agregarCriterio(filtroPorCreacion);
		filtroAnd.agregarCriterio(filtroPorNivelDeVerificacion);
		filtroOr.agregarCriterio(filtroAnd);
		filtroOr.agregarCriterio(filtroPorTipoDeInsecto);
		
		buscador.setMuestras(listaDeMuestrasB);
		buscador.setEstrategia(filtroOr);
		
		assertTrue(buscador.filtrar().contains(muestraVotadaA));
		
	}	

	
		
}
	