package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.time.LocalDate;

import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class Opinion {
	public Usuario usuario;
	public Muestra muestra;
	public String opinion;
	public LocalDate fecha;
	final String tipo;
	
	public Opinion(Usuario usuario, Muestra muestra, String opinion) {
		this.usuario = usuario;
		this.muestra = muestra;
		this.opinion = opinion;
		this.fecha = LocalDate.now();
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

	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getTipo() {
		return tipo;
	}

}
