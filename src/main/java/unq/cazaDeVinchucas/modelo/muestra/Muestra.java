package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;

public class Muestra {
	public Usuario usuarioDueñoDeLaMuestra;
	public File fotoDeLaMuestra; 
	public Ubicacion ubicacionDeLaMuestra;
	public LocalDate fechaDeCreacion; 
	private EstadoMuestra estadoDeLaMuestra = new EstadoNormal(this);
	public List<Opinion> opinionesDeLaMuestra = new ArrayList<Opinion>();
	
	//Constructor de la muestra:
	public Muestra(Usuario usuarioDueñoDeLaMuestra, File fotoDeLaMuestra, Ubicacion ubicacionDeLaMuestra) {
		this.usuarioDueñoDeLaMuestra = usuarioDueñoDeLaMuestra;
		this.fotoDeLaMuestra = fotoDeLaMuestra;
		this.ubicacionDeLaMuestra = ubicacionDeLaMuestra;
		this.fechaDeCreacion = LocalDate.now();
	}
	
	//Getters y Setters de la muestra:
	public void agregarOpinion(Opinion opinionAAgregar) {
		this.estadoDeLaMuestra.agregarO(opinionAAgregar);
		this.estadoDeLaMuestra.corroborarEstado();
	}
	
	public void agregarO(Opinion opinionAAgregar) {
		this.opinionesDeLaMuestra.add(opinionAAgregar);
	}
	
	public List<Opinion> getOpinionesDeLaMuestra() {
		return this.opinionesDeLaMuestra;
	}
		
	public File getFotoDeLaMuestra() {
		return this.fotoDeLaMuestra;
	}

	public Ubicacion getUbicacionDeLaMuestra() {
		return this.ubicacionDeLaMuestra;
	}
	
	public LocalDate getFechaDeCreacion() {
		return this.fechaDeCreacion;
	}
	
	public EstadoMuestra getEstadoDeLaMuestra() {
		return this.estadoDeLaMuestra;
	}

	public void setEstadoDeLaMuestra(EstadoMuestra estadoDeLaMuestra) {
		this.estadoDeLaMuestra = estadoDeLaMuestra;
	}

	public List<String> getListaDeResultadosDeOpinionDeLaMuestra() {
		return opinionesDeLaMuestra.stream().map(o -> o.getOpinion()).toList();
	}
	
	public List<Opinion> getListaOpinionesExpertasDeLaMuestra() {
		return opinionesDeLaMuestra.stream().filter(o -> o.getTipo().equals("Experto")).toList();
	}
	
	public List<String> getListaDeResultadosExpertosDeLaMuestra() {
		return this.getListaOpinionesExpertasDeLaMuestra().stream().map(o -> o.getOpinion()).toList();
	}
	
	//Funcionalidad de la muestra:
	public String resultadoFinal() {
		return this.estadoDeLaMuestra.resultadoFinal();
	}
}