package main.java.unq.cazaDeVinchucas.modelo;

public class EVerificada extends EstadoDeLaMuestra {
	
	public EVerificada(Muestra muestra) {
		super(muestra);
	}

	@Override
	String resultadoFinal() {
		return null;
	}

	@Override
	EstadoDeLaMuestra siguienteEstado() {
		return null;
	}

	@Override
	String getEstado() {
		return "Verificada";
	}

	@Override
	boolean condicionDeCambioDeEstado() {
		return false;
	}
	
	
}
