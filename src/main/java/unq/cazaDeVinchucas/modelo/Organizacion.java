package main.java.unq.cazaDeVinchucas.modelo;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public abstract class Organizacion {
	private Ubicacion ubicacionDeLaOrganizacion; 
	private String tipoDeOrganizacion;
	private Integer cantidadDePersonal;
	private ManagerDeEventos managerDeEventos;
	

	public Organizacion(Ubicacion ubicacionDeLaOrganizacion, String tipoDeOrganizacion, Integer cantidadDePersonal) {
		super();
		this.ubicacionDeLaOrganizacion = ubicacionDeLaOrganizacion;
		this.tipoDeOrganizacion = tipoDeOrganizacion;
		this.cantidadDePersonal = cantidadDePersonal;
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

	public  void suscribirseA(ZonaDeCobertura zona) {
		managerDeEventos.suscribir(this,zona);
	}
	
	public  void desuscribirseA(ZonaDeCobertura zona) {
		managerDeEventos.desuscribir(this,zona);
	}
	
	abstract public FuncionalidadExterna funcionalidadNuevaMuestra();
	
	abstract public FuncionalidadExterna funcionalidadValidacionDeMuestra();


		
}
	


 