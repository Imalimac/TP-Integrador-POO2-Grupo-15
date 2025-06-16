package main.java.unq.cazaDeVinchucas.modelo;
import java.util.ArrayList;

public class RegionGeografica {
	private ArrayList<ZonaDeCobertura> zonasDeCoberturaDeLaRegion = new ArrayList<ZonaDeCobertura>();

	public RegionGeografica() {
		super();
	}

	public ArrayList<ZonaDeCobertura> getZonasDeCoberturaDeLaRegion() {
		return zonasDeCoberturaDeLaRegion;
	}

	public void agregarZonasDeCobertura(ZonaDeCobertura zonasAAgregar) {
		this.zonasDeCoberturaDeLaRegion.add(zonasAAgregar);
	}
	
	
}
