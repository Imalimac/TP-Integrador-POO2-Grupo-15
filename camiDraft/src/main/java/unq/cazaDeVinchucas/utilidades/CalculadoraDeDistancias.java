package main.java.unq.cazaDeVinchucas.utilidades;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;
import static java.lang.Math.atan2;



public class CalculadoraDeDistancias {
	
	
	
	public double calcularDistanciaHaversine(double lat1, double lon1, double lat2, double lon2) {
	    double R = 6371; // Radio de la Tierra en km
	    double latDist = toRadians(lat2 - lat1);
	    double lonDist = toRadians(lon2 - lon1);
	    double a = sin(latDist / 2) * sin(latDist / 2) + cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lonDist / 2) * sin(lonDist / 2);
	    double c = 2 * atan2(sqrt(a), sqrt(1 - a));
	    return R * c;
	}
	
	

}
