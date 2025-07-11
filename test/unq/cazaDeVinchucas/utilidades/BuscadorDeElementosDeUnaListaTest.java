package unq.cazaDeVinchucas.utilidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

import java.util.ArrayList;

class BuscadorDeElementosDeUnaListaTest {
	private BuscadorDeElementosDeUnaLista<String> buscadorDeElementos;
	private BuscadorDeElementosDeUnaLista<Integer> buscadorDeIntegers;
	private ArrayList<String> unaListaDeElementos;
	private ArrayList<Integer> unaListaDeEnteros;

	@BeforeEach
	public void setUp() {
		this.buscadorDeElementos = new BuscadorDeElementosDeUnaLista<String> ();
		this.buscadorDeIntegers = new BuscadorDeElementosDeUnaLista<Integer> ();
		
		this.unaListaDeElementos = new  ArrayList<String>();
		this.unaListaDeElementos.add("uno");
		this.unaListaDeElementos.add("dos");
		this.unaListaDeElementos.add("dos");
		this.unaListaDeElementos.add("tres");
		
		this.unaListaDeEnteros = new ArrayList<Integer>();
		this.unaListaDeEnteros.add(1);
		this.unaListaDeEnteros.add(1);
		this.unaListaDeEnteros.add(2);
		this.unaListaDeEnteros.add(2);
		this.unaListaDeEnteros.add(3);
	}
	
	
	@Test
	void encontrarElementoMasComun() {
		assertEquals(this.buscadorDeElementos.encontrarElementoMasComun(this.unaListaDeElementos), "dos");
	}
	

	@Test
	void hayUnUnicoElementoConFrecuenciaMaxima() {
		assertFalse(this.buscadorDeIntegers.hayUnUnicoElementoConFrecuenciaMaxima(unaListaDeEnteros));
		assertTrue(this.buscadorDeElementos.hayUnUnicoElementoConFrecuenciaMaxima(unaListaDeElementos));
	}

}