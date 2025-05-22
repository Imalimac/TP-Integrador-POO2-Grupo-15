package main.java.unq.cazaDeVinchucas.modelo;

public abstract class Usuario {

	public Integer cantidadDeEnvios;
	public Integer cantidadDeRevisiones;
	
	public NivelDeExperiencia nivelDeUsuario() {
		if (this.cumpleCondicionDeExperto()) {
			return NivelDeExperiencia.Experto;
		} else {
			return NivelDeExperiencia.Basico;
		}
	}
	
	abstract boolean cumpleCondicionDeExperto(); 
}
