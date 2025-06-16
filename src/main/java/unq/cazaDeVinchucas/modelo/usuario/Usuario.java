package main.java.unq.cazaDeVinchucas.modelo.usuario;
import java.util.ArrayList;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;

public abstract class Usuario {

	private Integer cantidadDeEnvios;
	private Integer cantidadDeRevisiones;
	private ArrayList<Muestra>muestrasOpinadas = new ArrayList<Muestra>();
	
	
	public String nivelDeUsuario() {
		if (this.cumpleCondicionDeExperto()) {
			return "Experto";
		} else {
			return "Basico";
		}
	}
	
	public Integer getCantidadDeEnvios() {
		return cantidadDeEnvios;
	}

	public void setCantidadDeEnvios(Integer cantidadDeEnvios) {
		this.cantidadDeEnvios = cantidadDeEnvios;
	}

	public Integer getCantidadDeRevisiones() {
		return cantidadDeRevisiones;
	}

	public void setCantidadDeRevisiones(Integer cantidadDeRevisiones) {
		this.cantidadDeRevisiones = cantidadDeRevisiones;
	}

	public ArrayList<Muestra> getMuestrasOpinadas() {
		return muestrasOpinadas;
	}

	public void opinarSobreUnaMuestra(Muestra muestra, String opinion) {
		if(!this.getMuestrasOpinadas().contains(muestra) && muestra.getEstadoDeLaMuestra().getEstado()!="Verificada") {
		muestra.agregarOpinion(new Opinion(this, muestra, opinion));
		this.cantidadDeRevisiones = this.cantidadDeRevisiones + 1; 
		this.muestrasOpinadas.add(muestra);
		}
	}
	
	abstract boolean cumpleCondicionDeExperto(); 
}
