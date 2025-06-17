package main.java.unq.cazaDeVinchucas.modelo.muestra;

public abstract class EstadoMuestra {
	private Muestra muestra;

	
	public EstadoMuestra(Muestra muestra) {
		this.setMuestra(muestra);
	}

	public Muestra getMuestra() {
		return muestra;
	}
	
	private void setMuestra(Muestra muestra) {
		this.muestra = muestra;
	}
	
	public void cambiarEstado() {
		this.getMuestra().setEstadoDeLaMuestra(this.siguienteEstado());	
	}

	public void corroborarEstado() {
		if(this.condicionDeCambioDeEstado()) {
			this.getMuestra().setEstadoDeLaMuestra(this.siguienteEstado());
		}
	}
	
	protected abstract void agregarO(Opinion opinionAAgregar);
	public abstract String resultadoFinal();
	protected abstract EstadoMuestra siguienteEstado();
	public abstract boolean condicionDeCambioDeEstado();
	public abstract String getEstado();
}
