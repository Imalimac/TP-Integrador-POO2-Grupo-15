package main.java.unq.cazaDeVinchucas.modelo;

import java.util.ArrayList;
import java.util.List;

import main.java.unq.cazaDeVinchucas.controlador.ManagerDeEventos;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;

public class ZonaDeCobertura {
	private Ubicacion epicentro;
	private Integer radio; //Esta distancia representa KM.
	private String nombre;
	private ArrayList<Muestra> muestrasDeLaZona = new ArrayList<Muestra>();
	private ManagerDeEventos managerDeEventos = ManagerDeEventos.getInstancia();
	
	public ZonaDeCobertura(Ubicacion epicentro, Integer radio, String nombre) {
		this.epicentro = epicentro;
		this.radio = radio;
		this.nombre = nombre;
		this.managerDeEventos.agregarZonaDeCoberturaNueva(this);
		this.agregarMuestrasALaZona();
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public Integer getRadio() {
		return radio;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarMuestrasALaZona() {
		for(Muestra muestra : managerDeEventos.getMuestrasReportadas()) {
			if(this.contieneUbicacion(muestra.getUbicacionDeLaMuestra())) {
		}
			muestrasDeLaZona.add(muestra);
		}
	} 

	public ArrayList<Muestra> getMuestrasDeLaZona() {
		return muestrasDeLaZona;
	}
	
    public boolean contieneMuestra(Muestra muestra) {
        return muestrasDeLaZona.contains(muestra);
    }


	//Devuelve si una zona se solapa con otra zona
	public boolean seSolapaCon(ZonaDeCobertura otraZona) {
        final double distanciaEntreEpicentros = this.getEpicentro().distanciaEntreDosUbicaciones(this.getEpicentro(), otraZona.getEpicentro());
        
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
        double distancia = this.getEpicentro().distanciaEntreDosUbicaciones(this.getEpicentro(), ubicacion);
        return distancia <= this.radio;
    }

}
