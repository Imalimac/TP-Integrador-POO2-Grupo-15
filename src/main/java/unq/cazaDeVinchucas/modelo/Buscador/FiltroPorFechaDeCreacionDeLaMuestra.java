package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import java.time.LocalDate;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;

public class FiltroPorFechaDeCreacionDeLaMuestra implements CriterioDeFiltracion {
    private LocalDate fecha;

    public FiltroPorFechaDeCreacionDeLaMuestra() {
        this.fecha = LocalDate.now();
    }
    
    public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
    
    @Override
    public boolean cumpleCriterio(Muestra muestra) {
        return muestra.getFechaDeCreacion() == fecha;
    }
    

}

