package main.java.unq.cazaDeVinchucas.utilidades;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuscadorDeElementosDeUnaLista <T>{

	//Constructor del Buscador
	public BuscadorDeElementosDeUnaLista() {
		super();
	}

	//Funciones:
	
	//Encuentra el elemento mas comun de una lista.
	public T encontrarElementoMasComun(List<T> lista) {
		// Map para contar la frecuencia
		Map<T, Integer> frecuencia = new HashMap<>();
			for (T elemento : lista) {
				frecuencia.put(elemento, frecuencia.getOrDefault(elemento, 0) + 1);
			}

		// Encontrar el elemento más común
		T masComun = Collections.max(frecuencia.entrySet(), Map.Entry.comparingByValue()).getKey();
			return masComun;
	}

	//Devuelve si hay un único elemento con una frecuencia máxima de apariciones.
	public boolean hayUnUnicoElementoConFrecuenciaMaxima(List<T> lista) {
		// Paso 1: Contamos la frecuencia de cada elemento
		Map<T, Integer> frecuencia = new HashMap<>();
		for (T elemento : lista) {
			frecuencia.put(elemento, frecuencia.getOrDefault(elemento, 0) + 1);
		}

		// Paso 2: Encontramos la frecuencia máxima
		int maxFrecuencia = Collections.max(frecuencia.values());

		// Paso 3: Contamos cuántos elementos tienen esa frecuencia máxima
		long cantidadMaxFrecuencia = frecuencia.values().stream().filter(f -> f == maxFrecuencia).count();
        boolean esUnico = cantidadMaxFrecuencia == 1;
        	return esUnico;
    }
}
