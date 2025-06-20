package main.java.unq.cazaDeVinchucas.servicio;

import main.java.unq.cazaDeVinchucas.modelo.Organizacion;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public interface FuncionalidadExterna{

	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zonaDeCobertura, Muestra muestra);
	
}