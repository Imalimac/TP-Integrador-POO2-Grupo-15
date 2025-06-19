package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import java.util.ArrayList;
import java.util.List;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;

public class FiltroOr implements CriterioDeFiltracion{
    private List<CriterioDeFiltracion> estrategias = new ArrayList <CriterioDeFiltracion>();
    
    public FiltroOr() {
		super();
	}

	public void agregarCriterio(CriterioDeFiltracion estrategia) {
        this.estrategias.add(estrategia);
    }

    @Override
    public boolean cumpleCriterio(Muestra muestra) {
        return estrategias.stream().anyMatch(estrategia -> estrategia.cumpleCriterio(muestra));
    }
}
