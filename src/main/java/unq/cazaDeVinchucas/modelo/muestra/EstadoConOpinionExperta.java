package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.util.Collections;
import java.util.List;

import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

public class EstadoConOpinionExperta extends EstadoMuestra {

	public EstadoConOpinionExperta(Muestra muestra) {
		super(muestra);
	}

	@Override
	public String resultadoFinal() {
		List<String> listaDeResultadosOpinionesExpertas = this.getMuestra().getListaDeResultadosExpertosDeLaMuestra();
		
		BuscadorDeElementosDeUnaLista <String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		
		if(buscador.hayUnUnicoElementoConFrecuenciaMaxima(listaDeResultadosOpinionesExpertas)) {
			return buscador.encontrarElementoMasComun(listaDeResultadosOpinionesExpertas);
		}else {
			return "No definido.";
		}
	}

	@Override
	public EstadoMuestra siguienteEstado() {
		return new EstadoVerificada(this.getMuestra());
	}

	@Override
	public boolean condicionDeCambioDeEstado() {
		final BuscadorDeElementosDeUnaLista<String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		List<String> listaDeResultadosOpinionesExpertas = this.getMuestra().getListaDeResultadosExpertosDeLaMuestra();
		
		return buscador.hayUnUnicoElementoConFrecuenciaMaxima(listaDeResultadosOpinionesExpertas)
				&& Collections.frequency(listaDeResultadosOpinionesExpertas, buscador
						.encontrarElementoMasComun(listaDeResultadosOpinionesExpertas)) == 2; 
	}
	
	@Override
	public String getEstado() {
		return "ConOpinionExperta";
	}

	@Override
	public void agregarO(Opinion opinionAAgregar) {
		if(opinionAAgregar.getTipo().equals("Experto")) {
			this.getMuestra().agregarO(opinionAAgregar);
		} else {
			throw new RuntimeException("No se puede agregar una nueva opinion porque no es una opinion experta.");
		}
	}
}
