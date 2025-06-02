package main.java.unq.cazaDeVinchucas.modelo;

import java.util.ArrayList;
import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

public class Normal extends EstadoDeLaMuestra {

	public Normal(Muestra muestra) {
		super(muestra);
	}

	@Override
	String resultadoFinal() {
		final BuscadorDeElementosDeUnaLista<String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		ArrayList<String> resultadosDeOpinion = this.getMuestra().getListaDeResultadosDeOpinionDeUnaLista(this.getMuestra().getOpinionesDeLaMuestra());
		
		if(buscador.hayUnUnicoElementoConFrecuenciaMaxima(resultadosDeOpinion)) {
			return buscador.encontrarElementoMasComun(resultadosDeOpinion);
		}else {
			return "No definido.";
		}
	}

	@Override
	public EstadoDeLaMuestra siguienteEstado() {
		return new ConOpinionExperta(this.getMuestra());
	}

	@Override
	public boolean condicionDeCambioDeEstado() {
		return !this.getMuestra().getListaDeResultadosDeOpinionDeUnaLista(this.getMuestra().getOpinionesDeLaMuestra()).contains("Experto");
	}

	@Override
	String getEstado() {
		return "Normal";
	}
	
	
	
}
