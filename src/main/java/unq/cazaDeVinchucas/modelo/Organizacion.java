package main.java.unq.cazaDeVinchucas.modelo;
import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public abstract class Organizacion {
	private Ubicacion ubicacionDeLaOrganizacion; 
	private String tipoDeOrganizacion;
	private Integer cantidadDePersonal;
	private List<ZonaDeCobertura>suscripciones;
	private ManagerDeEventos managerDeEventos;
	

	public Organizacion(Ubicacion ubicacionDeLaOrganizacion, String tipoDeOrganizacion, Integer cantidadDePersonal) {
		super();
		this.ubicacionDeLaOrganizacion = ubicacionDeLaOrganizacion;
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.cantidadDePersonal = cantidadDePersonal;
		this.suscripciones = new ArrayList<>();
		this.managerDeEventos = ManagerDeEventos.getInstancia();
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

	public Integer getCantidadDePersonal() {
		return cantidadDePersonal;
	}

	public void setCantidadDePersonal(Integer cantidadDePersonal) {
		this.cantidadDePersonal = cantidadDePersonal;
	}

	public List<ZonaDeCobertura> getSuscripciones() {
		return suscripciones;
	}
	
	public  void suscribirseA(ZonaDeCobertura zona) {
		suscripciones.add(zona);
		managerDeEventos.suscribir(this,zona);
	}
	
	public  void desuscribirseA(ZonaDeCobertura zona) {
		suscripciones.remove(zona);
		managerDeEventos.desuscribir(this,zona);
	}
	
	abstract public FuncionalidadExterna funcionalidadNuevaMuestra();
	
	abstract public FuncionalidadExterna funcionalidadValidacionDeMuestra();


		
}
	


 