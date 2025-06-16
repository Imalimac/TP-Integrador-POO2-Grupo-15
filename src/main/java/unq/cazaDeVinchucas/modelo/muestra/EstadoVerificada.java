package main.java.unq.cazaDeVinchucas.modelo.muestra;

public class EstadoVerificada extends EstadoMuestra {
	
	public EstadoVerificada(Muestra muestra) {
		super(muestra);
	}

	@Override
	String resultadoFinal() {
		return null;
	}

	@Override
	EstadoMuestra siguienteEstado() {
		return null;
	}

	@Override
	public
	String getEstado() {
		return "Verificada";
	}

	@Override
	boolean condicionDeCambioDeEstado() {
		return false;
	}
	
	
}
