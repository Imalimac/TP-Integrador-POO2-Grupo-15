package main.java.unq.cazaDeVinchucas.modelo;

import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public class ZonaDeCobertura {
	private Ubicacion epicentro;
	private int radio; //Esta distancia representa KM.
	private String nombre;
	private ArrayList<Muestra> muestrasDeLaZona = new ArrayList<Muestra>();
	private ManagerDeEventos managerDeEventos = ManagerDeEventos.getInstancia();
	
	public ZonaDeCobertura(Ubicacion epicentro, int radio, String nombre) {
		this.epicentro = epicentro;
		this.radio = radio;
		this.nombre = nombre;
		//this.managerDeEventos.agregarZonaDeCoberturaNueva(this); arreglar!!!!
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public int getRadio() {
		return radio;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarMuestrasALaZona() {
		muestrasDeLaZona.addAll(this.muestrasCoincidentesUbicacion().stream()
		.filter(m -> !this.muestrasDeLaZona.contains(m)).toList());
	} 
	
	public List<Muestra> muestrasCoincidentesUbicacion() {
		return managerDeEventos.getMuestrasReportadas().stream()
				.filter(m -> this.contieneUbicacion(m.getUbicacionDeLaMuestra())).toList();
	}
	
	public ArrayList<Muestra> getMuestrasDeLaZona() {
		return muestrasDeLaZona;
	}
	
    public boolean contieneMuestra(Muestra muestra) {
        return this.contieneUbicacion(muestra.getUbicacionDeLaMuestra());
    }

	//Devuelve si una zona se solapa con otra zona
	public boolean seSolapaCon(ZonaDeCobertura otraZona) {
        final double distanciaEntreEpicentros = this.getEpicentro().distanciaHaciaUbicacion(otraZona.getEpicentro());
        
        return distanciaEntreEpicentros < (this.radio + otraZona.radio);
    }
	
	//Devuelve dado una lista de zonas, aquellas que se solapan con la zona actual
    public List<ZonaDeCobertura> zonasSolapadas(List<ZonaDeCobertura> listaDeZonas) {
        List<ZonaDeCobertura> solapadas = new ArrayList<>();
        for (ZonaDeCobertura zona : listaDeZonas) {
            if (!this.equals(zona) && this.seSolapaCon(zona)) {
                solapadas.add(zona);
            }
        }
        return solapadas;
    }
	
    public boolean contieneUbicacion(Ubicacion ubicacion) {
        double distancia = this.getEpicentro().distanciaHaciaUbicacion(ubicacion);
        return distancia <= this.radio;
    }
}
