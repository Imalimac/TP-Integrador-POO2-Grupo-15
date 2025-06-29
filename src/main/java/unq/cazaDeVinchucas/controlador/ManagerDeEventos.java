package main.java.unq.cazaDeVinchucas.controlador;

import java.util.ArrayList;
import java.util.List;
import main.java.unq.cazaDeVinchucas.modelo.ZonaDeCobertura;
import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.modelo.Organizacion;

public class ManagerDeEventos {
	private static final ManagerDeEventos instancia = new ManagerDeEventos();
	private List<Muestra> muestrasReportadas = new ArrayList<Muestra>(); 
	private List<ZonaDeCobertura> zonasDeCobertura = new ArrayList<ZonaDeCobertura>(); 
	private List<Organizacion> suscriptores  = new ArrayList <Organizacion>();
	
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
		nuevaZonaDeCobertura.agregarMuestrasALaZona();
	}
	
	public List<Organizacion> getSuscriptores() {
		return suscriptores;
	}

	public void suscribir(Organizacion orga, ZonaDeCobertura zona) {
        if(!esSuscriptior(orga)) {
        	suscriptores.add(orga);
        	orga.suscribirseA(zona);
        }
    }

    public void desuscribir(Organizacion orga, ZonaDeCobertura zona) {
    	if(esSuscriptior(orga)) {
    		suscriptores.remove(orga);
    		orga.desuscribirseA(zona);
        }
    }
    
    private boolean esSuscriptior(Organizacion org) {
    	return suscriptores.contains(org);
    }
    
    public List<Organizacion> organizacionesSuscritasA(List<ZonaDeCobertura> zona) {
    	return suscriptores.stream().filter(o -> o.getSuscripciones().stream().anyMatch(s -> zona.contains(s))).toList();
    }

	public void notificarNuevaValidacionDeMuestra(List<ZonaDeCobertura> zona, Muestra muestra) {
		this.organizacionesSuscritasA(zona).forEach(o -> o.funcionalidadValidacionDeMuestra(zona.getFirst(), muestra));
	}
	
	public void notificarNuevaMuestra(List<ZonaDeCobertura> zona, Muestra muestra) {
		this.organizacionesSuscritasA(zona).forEach(o -> o.funcionalidadNuevaMuestra(zona.getFirst(), muestra));
	}
	
	public List<ZonaDeCobertura> zonaDe(Muestra muestra) {
		return zonasDeCobertura.stream().filter(z -> z.contieneMuestra(muestra)).toList();
	}
}
