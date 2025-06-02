package main.java.unq.cazaDeVinchucas.modelo;


public abstract class EstadoDeLaMuestra {
	private Muestra muestra;

	
	public EstadoDeLaMuestra(Muestra muestra) {
		super();
		this.muestra = muestra;
	}

	public Muestra getMuestra() {
		return muestra;
	}
	
	public void cambiarEstado() {
		this.muestra.setEstadoDeLaMuestra(this.siguienteEstado());	
	}


	public void corroborarEstado() {
		if(this.condicionDeCambioDeEstado()) {
			this.getMuestra().setEstadoDeLaMuestra(this.siguienteEstado());
		};
	}

	abstract String resultadoFinal();
	abstract EstadoDeLaMuestra siguienteEstado();
	abstract boolean condicionDeCambioDeEstado();
	abstract String getEstado();
	

}
