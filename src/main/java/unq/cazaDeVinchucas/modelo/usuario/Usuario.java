package main.java.unq.cazaDeVinchucas.modelo.usuario;
import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Opinion;

import java.io.File;
import java.time.LocalDate;

public class Usuario {
	private List<LocalDate> fechasDeEnvios = new ArrayList<>();
	private List<LocalDate> fechasDeRevisiones = new ArrayList<>();
	private List<Muestra>muestrasOpinadas = new ArrayList<Muestra>();
	private List<Muestra>muestrasEnviadas = new ArrayList<Muestra>();
	
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
		return muestrasEnviadas;
	}
	
	public List<LocalDate> getfechasDeRevisiones() {
		return fechasDeRevisiones;
	}
	
	public void enviarUnaMuestra(File fotoDeLaMuestra, Ubicacion ubicacionDeLaMuestra) {
		this.muestrasEnviadas.add(new Muestra(this,fotoDeLaMuestra, ubicacionDeLaMuestra));
		this.registrarEnvio();
	}
	
	public void registrarEnvio() {
	    fechasDeEnvios.add(LocalDate.now());
	}

	public void opinarSobreUnaMuestra(Muestra muestra, String opinion) {
		if(!this.getMuestrasOpinadas().contains(muestra) && muestra.getEstadoDeLaMuestra().getEstado()!="Verificada") {
		muestra.agregarOpinion(new Opinion(this, muestra, opinion));
		this.registrarRevision(); 
		this.muestrasOpinadas.add(muestra);
		}
	}
	
	public void registrarRevision() {
	    fechasDeRevisiones.add(LocalDate.now());
	}

	public boolean cumpleCondicionDeExperto() {
		LocalDate hoy = LocalDate.now();
	    LocalDate hace30Dias = hoy.minusDays(30);

	    long cantidadEnviosRecientes = fechasDeEnvios.stream()
	        .filter(fecha -> !fecha.isBefore(hace30Dias))
	        .count();

	    long cantidadRevisionesRecientes = fechasDeRevisiones.stream()
	        .filter(fecha -> !fecha.isBefore(hace30Dias))
	        .count();

	    return cantidadEnviosRecientes > 10 && cantidadRevisionesRecientes > 20;
	} 
}
