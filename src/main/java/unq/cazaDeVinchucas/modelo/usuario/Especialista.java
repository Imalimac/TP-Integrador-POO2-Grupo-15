package main.java.unq.cazaDeVinchucas.modelo.usuario;

public class Especialista extends Usuario{

	public Especialista() {
		super();
	}

	@Override
	public boolean cumpleCondicionDeExperto() {
		return true;
	}

	
}
