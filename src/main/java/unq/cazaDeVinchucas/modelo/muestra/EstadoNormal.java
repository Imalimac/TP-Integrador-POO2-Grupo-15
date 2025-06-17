package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.util.List;

import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

public class EstadoNormal extends EstadoMuestra {

	public EstadoNormal(Muestra muestra) {
		super(muestra);
	}

	@Override
	public String resultadoFinal() {
		final BuscadorDeElementosDeUnaLista<String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		List<String> resultadosDeOpinion = this.getMuestra().getListaDeResultadosDeOpinionDeLaMuestra();
		
		if(buscador.hayUnUnicoElementoConFrecuenciaMaxima(resultadosDeOpinion)) {
			return buscador.encontrarElementoMasComun(resultadosDeOpinion);
		}else {
			return "No definido.";
		}
	}

	@Override
	public EstadoMuestra siguienteEstado() {
		return new EstadoConOpinionExperta(this.getMuestra());
	}

	@Override
	public boolean condicionDeCambioDeEstado() {
		return !this.getMuestra().getListaOpinionesExpertasDeLaMuestra().isEmpty();
	}

	@Override
	public String getEstado() {
		return "Normal";
	}
	
	@Override
	public void agregarO(Opinion opinionAAgregar) {
		this.getMuestra().agregarO(opinionAAgregar);
	}
}
