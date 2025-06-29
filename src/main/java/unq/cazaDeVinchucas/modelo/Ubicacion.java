package main.java.unq.cazaDeVinchucas.modelo;
import main.java.unq.cazaDeVinchucas.utilidades.CalculadoraDeDistancias;

public class Ubicacion {
    private double latitud;
    private double longitud;
    
    public Ubicacion(double latitud, double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public double distanciaHaciaUbicacion(Ubicacion ubicacion) {
    	final CalculadoraDeDistancias calculadora = new CalculadoraDeDistancias();
        	
    	return calculadora.calcularDistancia(this.getLatitud(), this.getLongitud(), ubicacion.getLatitud(), ubicacion.getLongitud());
    }
	

	
}
