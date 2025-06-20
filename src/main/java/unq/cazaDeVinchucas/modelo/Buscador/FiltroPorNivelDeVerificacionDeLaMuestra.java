package main.java.unq.cazaDeVinchucas.modelo.Buscador;

import main.java.unq.cazaDeVinchucas.modelo.muestra.Muestra;
import main.java.unq.cazaDeVinchucas.servicio.CriterioDeFiltracion;


public class FiltroPorNivelDeVerificacionDeLaMuestra  implements CriterioDeFiltracion {
	   private String nivelDeVerificacion;

	   public FiltroPorNivelDeVerificacionDeLaMuestra() {
		   super();
	   }
	   
	   public void setNivelDeVerificacion(String nivelDeVerificacion) {
		   this.nivelDeVerificacion = nivelDeVerificacion;
	   }



		@Override
	    public boolean cumpleCriterio(Muestra muestra) {
	    	String estadoDeVerificacion;
	    			
	    	if(muestra.getEstadoDeLaMuestra().getEstado() == "Verificada") {
	    		estadoDeVerificacion = "Verificada";
	    	} else {estadoDeVerificacion = "Votada";}
	        
	    	return estadoDeVerificacion == this.nivelDeVerificacion;
	    }

}