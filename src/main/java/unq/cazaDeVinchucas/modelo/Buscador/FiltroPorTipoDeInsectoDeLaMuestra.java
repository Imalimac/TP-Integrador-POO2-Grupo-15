package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;

public class FiltroPorTipoDeInsectoDeLaMuestra implements CriterioDeFiltracion {
	    private String tipoDeInsecto;

	    public FiltroPorTipoDeInsectoDeLaMuestra() {
	        super();
	    }

	    public void setTipoDeInsecto(String tipoDeInsecto) {
			this.tipoDeInsecto = tipoDeInsecto;
		}

		@Override
	    public boolean cumpleCriterio(Muestra muestra) {
	        return muestra.resultadoFinal() == this.tipoDeInsecto;
	    }
	}
