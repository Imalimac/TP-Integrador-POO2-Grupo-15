package main.java.unq.cazaDeVinchucas.controlador;

import java.util.ArrayList;

import main.java.unq.cazaDeVinchucas.modelo.Muestra;

public class GestorDeMuestras {
	private ArrayList<Muestra> bancoDeMuestras = new ArrayList<Muestra>();

	public GestorDeMuestras() {
		super();
	}

	public ArrayList<Muestra> getBancoDeMuestras() {
		return this.bancoDeMuestras;
	}
	
	public void agregarMuestra(Muestra muestraAAgregar) {
		this.bancoDeMuestras.add(muestraAAgregar);
	}
	
	//Implementaciones del controlador:
	
	
	
	
}
