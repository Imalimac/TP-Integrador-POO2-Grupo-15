package main.java.unq.cazaDeVinchucas.modelo.usuario;

public class Especialista extends Usuario{

	public Especialista() {
		super();
	}

	@Override
	boolean cumpleCondicionDeExperto() {
		return true;
	}

	
}
