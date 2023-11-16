package naviera;

import java.util.List;

import buque.Terminal;
import tramo.Tramo;
import viaje.Viaje;

public class Circuito {
	
	  private List<Tramo> tramos;
	  private List<Viaje> viajes;
	  private Terminal terminalOrigen;
	    
	    
	    public Terminal getTerminalOrigen() {
	        return terminalOrigen;
	    }

	    public int tiempoDesdeHastaEnHoras(Terminal t1, Terminal t2) {
	        //PRECONDICION : Existe un camino posible desde la t1 hasta la t2
	        Tramo tramoActual = encontrarTramo(t1);
	        
	        int totalDeHoras = tramoActual.getTiempoEstimadoEnHoras();

	        while (tramoActual.getTerminalLlegada() != t2) {
	            tramoActual = encontrarTramo(tramoActual.getTerminalLlegada());
	            totalDeHoras += tramoActual.getTiempoEstimadoEnHoras();
	        }

	        return totalDeHoras;
	    }
	    
	    public List<Tramo> getTramos(){
	    	return tramos;
	    }

	    private Tramo encontrarTramo(Terminal salida) {
	        return this.getTramos().stream()
	                     .filter(t -> t.getTerminalSalida() == salida)
	                     .findFirst()
	                     .orElse(null);
	    } 
}
