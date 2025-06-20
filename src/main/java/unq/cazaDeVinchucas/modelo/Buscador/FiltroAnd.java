package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import java.util.ArrayList;
import java.util.List;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;

public class FiltroAnd implements CriterioDeFiltracion {
    private List<CriterioDeFiltracion> estrategias = new ArrayList<CriterioDeFiltracion>();
    
    public FiltroAnd() {
		super();
	}

	public void agregarCriterio(CriterioDeFiltracion estrategia) {
        this.estrategias.add(estrategia);
    }

    @Override
    public boolean cumpleCriterio(Muestra muestra) {
        return estrategias.stream().allMatch(estrategia -> estrategia.cumpleCriterio(muestra));
    }
}
