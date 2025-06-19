package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;

import java.util.ArrayList;
import java.util.List;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public class BuscadorDeMuestras {
	private CriterioDeFiltracion estrategia;
	private List<Muestra> muestras = new ArrayList<Muestra>();
	
	
    public BuscadorDeMuestras() {
		super();
	}
    
    public void setEstrategia(CriterioDeFiltracion estrategia) {
		this.estrategia = estrategia;
	}

    public CriterioDeFiltracion estrategia() {
    	return estrategia;
    }
    
	public void setMuestras(List<Muestra> muestras) {
		this.muestras = muestras;
	}

	public List<Muestra> filtrar() {
        return muestras.stream()
            .filter(estrategia::cumpleCriterio)
            .toList();
    }
}