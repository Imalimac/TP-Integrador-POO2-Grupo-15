package main.java.unq.cazaDeVinchucas.modelo;
import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.FuncionalidadExterna;

public abstract class Organizacion {
	private FuncionalidadExterna funcionalidadExterna;
	private List<ZonaDeCobertura>zonas;
	
	public Organizacion (FuncionalidadExterna funcionalidadExterna) {
		this.funcionalidadExterna= funcionalidadExterna;
		this.zonas=new ArrayList<>();
	}
	public FuncionalidadExterna getFuncionalidadExterna() {
		return funcionalidadExterna;
	}
	
	
		public abstract void subirNuevaMuestra(ZonaDeCobertura areaCobertura, Muestra muestra);

		public abstract  void validarMuestra(ZonaDeCobertura areaCobertura, Muestra muestra);
		public  void registrarseA(ZonaDeCobertura zona) {
			zonas.add(zona);
		}
		public  void desregistrarseDe(ZonaDeCobertura zona) {
			zonas.remove(zona);
		}
		
	}
	


 