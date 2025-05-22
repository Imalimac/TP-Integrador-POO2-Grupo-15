package main.java.unq.cazaDeVinchucas.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Muestra {
	
	public ArrayList <Opinion> opinionesDeLaMuestra = new ArrayList <Opinion>();

	public File fotoDeLaMuestra; 
	public Ubicacion ubicacionDeLaMuestra;
	
	private boolean esVerificada = false;
	private boolean tieneOpinionExperta = false;
	
	public void agregarOpinion(Opinion opinionAAgregar) {
		if(opinionAAgregar.getTipo()== NivelDeExperiencia.Experto) {
			opinionesDeLaMuestra.add(opinionAAgregar);
			this.tieneOpinionExperta = true;
		} else {
			opinionesDeLaMuestra.add(opinionAAgregar);
		}
	}
	
	public OpinionDeLaMuestra resultadoFinal() {
		 if (! tieneOpinionExperta && !this.tieneEmpateDeOpiniones(this.listaDeResultadosDeOpinionDeUnaLista(opinionesDeLaMuestra))) {
			 return  this.opinionMayoritaria(this.listaDeResultadosDeOpinionDeUnaLista(opinionesDeLaMuestra));
		} else if (! tieneOpinionExperta && this.tieneEmpateDeOpiniones(this.listaDeResultadosDeOpinionDeUnaLista(opinionesDeLaMuestra))) {
			return OpinionDeLaMuestra.noDefinido;
		} else if  (tieneOpinionExperta && !this.tieneEmpateDeOpiniones(this.listaDeResultadosDeOpinionDeUnaLista(this.getListaOpinionesExpertasDeLaMuestra()))) {
			return this.opinionMayoritaria(this.listaDeResultadosDeOpinionDeUnaLista(this.getListaOpinionesExpertasDeLaMuestra()));
		} else {
			return OpinionDeLaMuestra.noDefinido; 
		}
	}

	
	public ArrayList<Opinion> getOpinionesDeLaMuestra() {
		return opinionesDeLaMuestra;
	}
	
	public ArrayList<Opinion> getListaOpinionesExpertasDeLaMuestra() {
		ArrayList <Opinion> listaDeOpinionesExpertas = new ArrayList <Opinion>();
		for (Opinion opinion : this.opinionesDeLaMuestra) {
			if(opinion.getTipo()==NivelDeExperiencia.Experto) {
				listaDeOpinionesExpertas.add(opinion);
			}
		}
			return listaDeOpinionesExpertas;
	}
	
	public File getFotoDeLaMuestra() {
		return fotoDeLaMuestra;
	}

	public Ubicacion getUbicacionDeLaMuestra() {
		return ubicacionDeLaMuestra;
	}

	public boolean esVerificada() {
		return esVerificada;
	}
	
	public ArrayList <OpinionDeLaMuestra> listaDeResultadosDeOpinionDeUnaLista(ArrayList <Opinion> unaLista) {
		final ArrayList <OpinionDeLaMuestra> listaDeOpiniones = new ArrayList <OpinionDeLaMuestra>();
		
		for (Opinion opinion : unaLista) {
			listaDeOpiniones.add(opinion.getOpinion());
		}
		
		return listaDeOpiniones;
	}
	
	
	
	public OpinionDeLaMuestra opinionMayoritaria(ArrayList <OpinionDeLaMuestra>lista) {
		return this.encontrarElementoMasComun(lista);
	}
	
	public <T> T encontrarElementoMasComun(ArrayList<T> lista) {
	        if (lista == null || lista.isEmpty()) {
	            return null; // Se puede agregar una excepción.
	        }

	        Map<T, Integer> conteo = new HashMap<>();
	        T elementoMasComun = null;
	        int frecuenciaMaxima = 0;

	        for (T elemento : lista) {
	            conteo.put(elemento, conteo.getOrDefault(elemento, 0) + 1);
	            if (conteo.get(elemento) > frecuenciaMaxima) {
	                frecuenciaMaxima = conteo.get(elemento);
	                elementoMasComun = elemento;
	            } 
	        }

	        return elementoMasComun;
	}
	
	public boolean tieneEmpateDeOpiniones(ArrayList <OpinionDeLaMuestra> listaDeResultados) {
        boolean tieneEmpate = false;
		
        Map<OpinionDeLaMuestra, Integer> conteo = new HashMap<>();
        int frecuenciaMaxima = 0;

        for (OpinionDeLaMuestra elemento : listaDeResultados) {
            conteo.put(elemento, conteo.getOrDefault(elemento, 0) + 1);
            if (conteo.get(elemento) == frecuenciaMaxima) {
                tieneEmpate= true;
            } 
        }

        return tieneEmpate;
	}	
}


