package main.java.unq.cazaDeVinchucas.servicio;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public interface CriterioDeFiltracion {
	
	public boolean cumpleCriterio(Muestra muestra);
}
