package main.java.unq.cazaDeVinchucas.servicio;

import main.java.unq.cazaDeVinchucas.modelo.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.Organizacion;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;

public interface FuncionalidadExterna{

	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zonaDeCobertura, Muestra muestra);
	
}