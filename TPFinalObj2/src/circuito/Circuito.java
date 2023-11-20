package circuito;

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

	private Tramo encontrarTramo(Terminal salida) {
	    return tramos.stream()
	                 .filter(t -> t.getTerminalSalida() == salida)
	                 .findFirst()
	                 .orElse(null);
	}
	

	public double precioDesdeHasta(Terminal t1, Terminal t2) {
		//PRECONDICION : Existe un camino posible desde la t1 hasta la t2
	    Tramo tramoActual = encontrarTramo(t1);
	    
	    double totalPrecio = tramoActual.getPrecioTramo();

	    while (tramoActual.getTerminalLlegada() != t2) {
	        tramoActual = encontrarTramo(tramoActual.getTerminalLlegada());
	        totalPrecio += tramoActual.getPrecioTramo();
	    }

	    return totalPrecio;
}

	public int cantidadIntermediaria(Terminal t1, Terminal t2) {
		//PRECONDICION : Existe un camino posible desde la t1 hasta la t2
		 Tramo tramoActual = encontrarTramo(t1);
		    
		    int totalCantidadIntermediaria = 0;

		    while (tramoActual.getTerminalLlegada() != t2) {
		        tramoActual = encontrarTramo(tramoActual.getTerminalLlegada());
		        totalCantidadIntermediaria += 1;
		    }

		    return totalCantidadIntermediaria;
	}

	public boolean contieneTerminal(Terminal terminalGestionada) {
		// TODO Auto-generated method stub
		return tramos.stream().anyMatch(t->t.tieneLaTerminal(terminalGestionada));
	}
}
