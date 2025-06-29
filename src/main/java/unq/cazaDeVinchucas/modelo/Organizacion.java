package main.java.unq.cazaDeVinchucas.modelo;

import java.util.ArrayList;
import java.util.List;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public class Organizacion {
	private Ubicacion ubicacionDeLaOrganizacion; 
	private String tipoDeOrganizacion;
	private int cantidadDePersonal;
	private FuncionalidadExterna funcionalidadNuevaMuestra;
	private FuncionalidadExterna funcionalidadValidacionDeMuestra;
	private List<ZonaDeCobertura> suscripciones = new ArrayList<ZonaDeCobertura>();
	

	public Organizacion(Ubicacion ubicacionDeLaOrganizacion, String tipoDeOrganizacion, int cantidadDePersonal,
			FuncionalidadExterna funcionalidadNuevaMuestra, FuncionalidadExterna funcionalidadValidacionDeMuestra) {
		this.ubicacionDeLaOrganizacion = ubicacionDeLaOrganizacion;
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.cantidadDePersonal = cantidadDePersonal;
		this.funcionalidadNuevaMuestra = funcionalidadNuevaMuestra;
		this.funcionalidadValidacionDeMuestra = funcionalidadValidacionDeMuestra;
	}

	//Getters y setters:
	public Ubicacion getUbicacionDeLaOrganizacion() {
		return ubicacionDeLaOrganizacion;
	}
	
	public void setUbicacionDeLaOrganizacion(Ubicacion ubicacionDeLaOrganizacion) {
		this.ubicacionDeLaOrganizacion = ubicacionDeLaOrganizacion;
	}

	public String getTipoDeOrganizacion() {
		return tipoDeOrganizacion;
	}

	public void setTipoDeOrganizacion(String tipoDeOrganizacion) {
		this.tipoDeOrganizacion = tipoDeOrganizacion;
	}

	public int getCantidadDePersonal() {
		return cantidadDePersonal;
	}

	public void setCantidadDePersonal(int cantidadDePersonal) {
		this.cantidadDePersonal = cantidadDePersonal;
	}
	
	public List<ZonaDeCobertura> getSuscripciones() {
		return this.suscripciones;
	}
	
	public void suscribirseA(ZonaDeCobertura zona) {
		this.suscripciones.add(zona);
	}
	
	public void desuscribirseA(ZonaDeCobertura zona) {
		this.suscripciones.remove(zona);
	}
	
	public void funcionalidadNuevaMuestra(ZonaDeCobertura zona, Muestra muestra) {
		this.funcionalidadNuevaMuestra.nuevoEvento(this, zona, muestra);
	}
	
	public void funcionalidadValidacionDeMuestra(ZonaDeCobertura zona, Muestra muestra) {
		this.funcionalidadValidacionDeMuestra.nuevoEvento(this, zona, muestra);
	} 
}