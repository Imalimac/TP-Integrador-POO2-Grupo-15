package main.java.unq.cazaDeVinchucas.modelo.muestra;

import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class Opinion {
	public Usuario usuario;
	public Muestra muestra;
	public String opinion;
	final String tipo;
	
	public Opinion(Usuario usuario, Muestra muestra, String opinion) {
		super();
		this.usuario = usuario;
		this.muestra = muestra;
		this.opinion = opinion;
		this.tipo = usuario.nivelDeUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public Muestra getMuestra() {
		return muestra;
	}

	public String getOpinion() {
		return opinion;
	}

	public String getTipo() {
		return tipo;
	}
	
}
