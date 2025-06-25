package unq.cazaDeVinchucas.utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.unq.cazaDeVinchucas.utilidades.CalculadoraDeDistancias;

class CalculadoraDeDistanciasTest {
	CalculadoraDeDistancias calculadora;
	
	double latitudDeCasaRosada = 34.608055555556;
	double longitudDeCasaRosada = 58.370277777778;
	double latitudDeCongreso = 34.609688;
	double longitudDeCongreso =  58.390461;
	
	
	@BeforeEach
	public void setUp() {
		calculadora = new CalculadoraDeDistancias();
	}
	
	/*La distancia "Haversine" entre el Congreso de la Nación Argentina y la Casa Rosada, es aproximadamente de 1.823 km.*/
	@Test
	void calcularDistancias() {
		assertEquals(calculadora.calcularDistancia(latitudDeCongreso, longitudDeCongreso, latitudDeCasaRosada, longitudDeCasaRosada), 1.8560420438028535);
	}

}
