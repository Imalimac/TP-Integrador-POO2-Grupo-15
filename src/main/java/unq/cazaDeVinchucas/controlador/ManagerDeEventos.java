package main.java.unq.cazaDeVinchucas.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.Organizacion;

public class ManagerDeEventos {
	private static final ManagerDeEventos instancia = new ManagerDeEventos();
	private List<Muestra> muestrasReportadas = new ArrayList<Muestra>(); 
	private List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<ZonaDeCobertura>(); 
	private Map <Organizacion, ZonaDeCobertura> suscriptores  = new HashMap <Organizacion, ZonaDeCobertura>();
	
	public static ManagerDeEventos getInstancia() {
		return instancia;
	}
	
	public List<Muestra> getMuestrasReportadas() {
		return muestrasReportadas;
	}

	public void agregarMuestra(Muestra nuevaMuestraReportada) {
		this.muestrasReportadas.add(nuevaMuestraReportada);
	}
	
	public List<ZonaDeCobertura> getZonasDeCobertura() {
		return zonasDeCobertura;
	}

	public void agregarZonaDeCoberturaNueva(ZonaDeCobertura nuevaZonaDeCobertura) {
		this.zonasDeCobertura.add(nuevaZonaDeCobertura);
	}


	public Map<Organizacion, ZonaDeCobertura> getSuscriptores() {
		return suscriptores;
	}

	public void suscribir(Organizacion organizacion, ZonaDeCobertura zona) {
        suscriptores.put(organizacion, zona);
    }

    public void desuscribir(Organizacion organizacion, ZonaDeCobertura zona) {
        suscriptores.remove(organizacion, zona);
    }
	
	public void notificarNuevaValidacionDeMuestra(Muestra muestra) {
		for (Map.Entry<Organizacion, ZonaDeCobertura> entrada : suscriptores.entrySet()) {
            ZonaDeCobertura zona = entrada.getValue();
            if (zona.contieneMuestra(muestra)) {
                Organizacion organizacion = entrada.getKey();
                organizacion.funcionalidadValidacionDeMuestra(zona, muestra);
            }
            //pasarlo como parametro con funcion auxiliar la funcionalidad interna
            
        }
	}
	
	public void notificarNuevaMuestra(Muestra muestra) {
		for (Map.Entry<Organizacion, ZonaDeCobertura> entrada : suscriptores.entrySet()) {
            ZonaDeCobertura zona = entrada.getValue();
            if (zona.contieneMuestra(muestra) ) {
                Organizacion organizacion = entrada.getKey();
                organizacion.funcionalidadNuevaMuestra(zona, muestra);
            }
        }
	}
	
	
}
