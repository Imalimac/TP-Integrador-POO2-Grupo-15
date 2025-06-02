package main.java.unq.cazaDeVinchucas.modelo;

import java.util.ArrayList;
import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

public class ConOpinionExperta extends EstadoDeLaMuestra {

	public ConOpinionExperta(Muestra muestra) {
		super(muestra);
	}

	@Override
	String resultadoFinal() {
		ArrayList<String> listaDeResultadosOpinionesExpertas = this.getMuestra().getListaDeResultadosDeOpinionDeUnaLista(this.getMuestra().getListaOpinionesExpertasDeLaMuestra());
		BuscadorDeElementosDeUnaLista <String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		
		if(buscador.hayUnUnicoElementoConFrecuenciaMaxima(listaDeResultadosOpinionesExpertas)) {
			return buscador.encontrarElementoMasComun(listaDeResultadosOpinionesExpertas);
		}else {
			return "No definido.";
		}
	}

	@Override
	EstadoDeLaMuestra siguienteEstado() {
		return null;
	}

	@Override
	boolean condicionDeCambioDeEstado() {
		final BuscadorDeElementosDeUnaLista<Opinion> buscador = new BuscadorDeElementosDeUnaLista<Opinion>();
		
		return (buscador.hayUnUnicoElementoConFrecuenciaMaxima(this.getMuestra().getListaOpinionesExpertasDeLaMuestra())); 
	}
	
	@Override
	String getEstado() {
		return "ConOpinionExperta";
	}
	


}
