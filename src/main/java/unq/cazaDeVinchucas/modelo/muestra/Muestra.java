package main.java.unq.cazaDeVinchucas.modelo.muestra;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.modelo.Ubicacion;
import main.java.unq.cazaDeVinchucas.modelo.usuario.Usuario;


public class Muestra {
	
	public Usuario usuarioDueñoDeLaMuestra;
	public File fotoDeLaMuestra; 
	public Ubicacion ubicacionDeLaMuestra;
	private EstadoMuestra estadoDeLaMuestra = new EstadoNormal(this);
	public List<Opinion> opinionesDeLaMuestra = new ArrayList<Opinion>();
	
	//Constructor de la muestra:
	public Muestra(Usuario usuarioDueñoDeLaMuestra, File fotoDeLaMuestra, Ubicacion ubicacionDeLaMuestra,
			EstadoMuestra estadoDeLaMuestra) {
		super();
		this.usuarioDueñoDeLaMuestra = usuarioDueñoDeLaMuestra;
		this.fotoDeLaMuestra = fotoDeLaMuestra;
		this.ubicacionDeLaMuestra = ubicacionDeLaMuestra;
		this.estadoDeLaMuestra = estadoDeLaMuestra;
	}
	
	//Getters y Setters de la muestra:
	
	public void agregarOpinion(Opinion opinionAAgregar) {
			this.opinionesDeLaMuestra.add(opinionAAgregar);
			this.estadoDeLaMuestra.corroborarEstado();
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
	
	public EstadoMuestra getEstadoDeLaMuestra() {
		return this.estadoDeLaMuestra;
	}

	public void setEstadoDeLaMuestra(EstadoMuestra estadoDeLaMuestra) {
		this.estadoDeLaMuestra = estadoDeLaMuestra;
	}

	public List<String> getListaDeResultadosDeOpinionDeUnaLista(List<Opinion> unaLista) {
		final List<String> listaDeOpiniones = new ArrayList<String>();
		
		for (Opinion opinion : unaLista) {
			listaDeOpiniones.add(opinion.getOpinion());
		}
		
		return listaDeOpiniones;
	}
	
	public List<Opinion> getListaOpinionesExpertasDeLaMuestra() {
		List<Opinion> listaDeOpinionesExpertas = new ArrayList<Opinion>();
		
		for (Opinion opinion : this.opinionesDeLaMuestra) {
			if(opinion.getTipo().equals("Experto")) {
				listaDeOpinionesExpertas.add(opinion);
			}
		}
		return listaDeOpinionesExpertas;
	}

	//Funcionalidad de la muestra:
	
	public String resultadoFinal() {
		return this.estadoDeLaMuestra.resultadoFinal();
	}

	
}


