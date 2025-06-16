package main.java.unq.cazaDeVinchucas.modelo;
import main.java.unq.cazaDeVinchucas.utilidades.CalculadoraDeDistancias;

public class Ubicacion {
    private double latitud;
    private double longitud;
    
    public Ubicacion(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public double distanciaEntreDosUbicaciones(Ubicacion primerUbicacion, Ubicacion segundaUbicacion) {
    	final CalculadoraDeDistancias calculadora = new CalculadoraDeDistancias();
        	
    	return calculadora.calcularDistanciaHaversine(primerUbicacion.getLatitud(),primerUbicacion.getLongitud(), segundaUbicacion.getLatitud(), segundaUbicacion.getLongitud());
    }
	

	
}
