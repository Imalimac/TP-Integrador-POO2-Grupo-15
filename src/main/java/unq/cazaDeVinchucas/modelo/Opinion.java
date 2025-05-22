package main.java.unq.cazaDeVinchucas.modelo;

public class Opinion {
	public Usuario usuario;
	public Muestra muestra;
	public OpinionDeLaMuestra opinion;
	final NivelDeExperiencia tipo = usuario.nivelDeUsuario();
	
	public Opinion(Usuario usuario, Muestra muestra, OpinionDeLaMuestra opinion) {
		super();
		this.usuario = usuario;
		this.muestra = muestra;
		this.opinion = opinion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Muestra getMuestra() {
		return muestra;
	}

	public OpinionDeLaMuestra getOpinion() {
		return opinion;
	}

	public NivelDeExperiencia getTipo() {
		return tipo;
	}
	
}
