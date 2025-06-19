package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

class FiltroPorFechaDeCreacionDeLaMuestraTest {
	
	Muestra muestraVerificada;
	Muestra muestraVotada;
	FiltroPorFechaDeCreacionDeLaMuestra filtroPorCreacion;
	LocalDate fechaPrimeroDeOctubre24;
	LocalDate fechaPrimeroDeOctubre23;
	
	
	@BeforeEach
	public void setUp() {
		//Filtro
		filtroPorCreacion = new FiltroPorFechaDeCreacionDeLaMuestra();
		
		//Fechas:
		fechaPrimeroDeOctubre24 = LocalDate.of(2024, 10, 01);
		fechaPrimeroDeOctubre23 = LocalDate.of(2023, 10, 01);
		
		//Muestra verificada
		muestraVerificada = mock(Muestra.class);
		when(muestraVerificada.getFechaDeCreacion()).thenReturn(fechaPrimeroDeOctubre24);

		//Muestra votada
		muestraVotada = mock(Muestra.class);
		when(muestraVotada.getFechaDeCreacion()).thenReturn(fechaPrimeroDeOctubre23);
	}
	

	
	@Test
	public void filtroPorFechaDeCreacion() {
		
		filtroPorCreacion.setFecha(fechaPrimeroDeOctubre23);
		assertTrue(filtroPorCreacion.cumpleCriterio(muestraVotada));
		assertFalse(filtroPorCreacion.cumpleCriterio(muestraVerificada));
	}


}
