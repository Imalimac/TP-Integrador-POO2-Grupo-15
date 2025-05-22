package main.java.unq.cazaDeVinchucas.modelo;
import java.util.ArrayList;

public class ZonaDeCobertura {
	private Ubicacion epicento;
	private Integer radio; //Esta distancia representa KM.
	private String nombre;
	private ArrayList<Muestra> muestrasDeLaZona = new ArrayList<Muestra>();
	
	public ZonaDeCobertura(Ubicacion epicento, Integer radio, String nombre) {
		super();
		this.epicento = epicento;
		this.radio = radio;
		this.nombre = nombre;
	}

	public Ubicacion getEpicento() {
		return epicento;
	}

	public Integer getRadio() {
		return radio;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Muestra> getMuestrasDeLaZona() {
		return muestrasDeLaZona;
	}
	
}
