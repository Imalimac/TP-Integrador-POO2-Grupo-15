package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.util.List;

import main.java.unq.cazaDeVinchucas.utilidades.BuscadorDeElementosDeUnaLista;

public class EstadoVerificada extends EstadoMuestra {
	
	public EstadoVerificada(Muestra muestra) {
		super(muestra);
	}

	@Override
	public String resultadoFinal() {
		List<String> listaDeResultadosOpinionesExpertas = this.getMuestra().getListaDeResultadosExpertosDeLaMuestra();
		BuscadorDeElementosDeUnaLista <String> buscador = new BuscadorDeElementosDeUnaLista<String>();
		
		return buscador.encontrarElementoMasComun(listaDeResultadosOpinionesExpertas);
	}

	@Override
	public EstadoMuestra siguienteEstado() {
		return null;
	}

	@Override
	public boolean condicionDeCambioDeEstado() {
		return false;
	}
	
	@Override
	public String getEstado() {
		return "Verificada";
	}

	@Override
	public void agregarO(Opinion opinionAAgregar) {
		System.out.println("La muestra ya está verificada. No se aceptan nuevas opiniones.");
	}
}
