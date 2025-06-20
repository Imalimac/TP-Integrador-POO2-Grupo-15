package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import java.time.LocalDate;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;

public class FiltroPorFechaDeUltimaVotacionDeLaMuestra implements CriterioDeFiltracion {
    private LocalDate fecha;

    public FiltroPorFechaDeUltimaVotacionDeLaMuestra() {
        super();
    }
    
    public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
    public LocalDate getFecha() {
    	return fecha;
    }

	@Override
    public boolean cumpleCriterio(Muestra muestra) {
        return muestra.getOpinionesDeLaMuestra().get(muestra.getOpinionesDeLaMuestra().size()-1).getFecha().equals(this.fecha);
    }
}
