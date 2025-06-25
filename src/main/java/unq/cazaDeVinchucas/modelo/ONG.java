package main.java.unq.cazaDeVinchucas.modelo;

import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public class ONG extends Organizacion{

	public ONG(Ubicacion ubicacionDeLaOrganizacion, String tipoDeOrganizacion, Integer cantidadDePersonal) {
		super(ubicacionDeLaOrganizacion, tipoDeOrganizacion, cantidadDePersonal);
	}

	@Override
	public FuncionalidadExterna funcionalidadNuevaMuestra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionalidadExterna funcionalidadValidacionDeMuestra() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
