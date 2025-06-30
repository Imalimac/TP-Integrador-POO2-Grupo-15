package main.java.unq.cazaDeVinchucas.modelo.usuario;
import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;

import java.io.File;
import java.time.LocalDate;

public class Usuario {
	private List<Muestra> muestrasOpinadas = new ArrayList<Muestra>();
	private List<Muestra> muestrasEnviadas = new ArrayList<Muestra>();
	
	public String nivelDeUsuario() {
		if (this.cumpleCondicionDeExperto()) {
			return "Experto";
		} else {
			return "Basico";
		}
	}
	
	public List<Muestra> getMuestrasOpinadas() {
		return muestrasOpinadas;
	}
	
	public List<Muestra> getMuestrasEnviadas() {
		return this.muestrasEnviadas;
	}
	
	public List<LocalDate> fechasDeRevision() {
		return this.muestrasOpinadas.stream().filter(m -> m.existeOpinionDeUsuario(this))
				.map(m -> m.getOpinionDelUsuario(this)).map(o -> o.getFecha()).toList();
	}
	
	public List<LocalDate> fechasDeEnvios() {
		return this.muestrasEnviadas.stream().map(f -> f.getFechaDeCreacion()).toList();
	}
	
	public void enviarUnaMuestra(File fotoDeLaMuestra, Ubicacion ubicacionDeLaMuestra) {
		this.muestrasEnviadas.add(new Muestra(this,fotoDeLaMuestra, ubicacionDeLaMuestra));
	}

	public void opinarSobreUnaMuestra(Muestra muestra, String opinion) {
		if(!this.getMuestrasOpinadas().contains(muestra) && muestra.getEstadoDeLaMuestra().getEstado()!="Verificada") {
		muestra.agregarOpinion(new Opinion(this, muestra, opinion));
		this.muestrasOpinadas.add(muestra);
		}
	}
	
	public boolean cumpleCondicionDeExperto() {
		LocalDate hoy = LocalDate.now();
	    LocalDate hace30Dias = hoy.minusDays(30);

	    long cantidadEnviosRecientes = this.fechasDeEnvios().stream()
	        .filter(fecha -> !fecha.isBefore(hace30Dias))
	        .count();

	    long cantidadRevisionesRecientes = this.fechasDeRevision().stream()
	        .filter(fecha -> !fecha.isBefore(hace30Dias))
	        .count();

	    return cantidadEnviosRecientes > 10 && cantidadRevisionesRecientes > 20;
	} 
}
