package main.java.unq.cazaDeVinchucas.controlador;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;

import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public class ManagerDeEventos {
	//private HashMap<Organizacion suscriptor, ZonaDeCobertura zona> suscriptores = new HashMap<Organizacion suscriptor, ZonaDeCobertura zona>();
	private List <Muestra> bancoDeMuestras;
	
	
	public ManagerDeEventos() {
		this.bancoDeMuestras= new ArrayList<>();
		
	}
	public List <Muestra> getBancoDeMuestras() {
		return this.getBancoDeMuestras();
	}
	
	public void agregarMuestra(Muestra muestraAAgregar) {
		this.bancoDeMuestras.add(muestraAAgregar);
	}

	

	
	
	
	
}
