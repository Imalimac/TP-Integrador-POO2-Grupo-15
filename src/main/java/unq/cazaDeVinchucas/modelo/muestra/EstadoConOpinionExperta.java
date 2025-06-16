package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.util.List;

import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

public class EstadoConOpinionExperta extends EstadoMuestra {

	public EstadoConOpinionExperta(Muestra muestra) {
		super(muestra);
	}

	@Override
	String resultadoFinal() {
		List<String> listaDeResultadosOpinionesExpertas = this.getMuestra().getListaDeResultadosDeOpinionDeUnaLista(this.getMuestra().getListaOpinionesExpertasDeLaMuestra());
		BuscadorDeElementosDeUnaLista <String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		
		if(buscador.hayUnUnicoElementoConFrecuenciaMaxima(listaDeResultadosOpinionesExpertas)) {
			return buscador.encontrarElementoMasComun(listaDeResultadosOpinionesExpertas);
		}else {
			return "No definido.";
		}
	}

	@Override
	EstadoMuestra siguienteEstado() {
		return new EstadoVerificada(this.getMuestra());
	}

	@Override
	boolean condicionDeCambioDeEstado() {
		final BuscadorDeElementosDeUnaLista<Opinion> buscador = new BuscadorDeElementosDeUnaLista<Opinion>();
		
		return (buscador.hayUnUnicoElementoConFrecuenciaMaxima(this.getMuestra().getListaOpinionesExpertasDeLaMuestra())); 
	}
	
	@Override
	public
	String getEstado() {
		return "ConOpinionExperta";
	}
	


}
