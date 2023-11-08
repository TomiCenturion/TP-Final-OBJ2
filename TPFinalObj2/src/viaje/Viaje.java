package viaje;

import java.time.LocalDate;
import java.util.List;

import Buque.Buque;
import Buque.Terminal;
import circuito.Circuito;

public class Viaje {
	private Buque buque;
	private LocalDate fechaSalida;
	private Circuito circuito;
	
	public Buque getBuque() {
		// TODO Auto-generated method stub
		return buque;
	}

	public List<Tramo> getTramosDe(TerminalGestionada terminalGestionada, Terminal destino) {
		// TODO Auto-generated method stub
		return null;
	} //HACER
	
	public LocalDate fechaDeSalidaDe(Terminal t) {
		int diasDeOrigenteAT = circuito.tiempoDesdeHastaEnHoras(circuito.getTerminalOrigen(), t) /24 ;
		return fechaSalida.plusDays(diasDeOrigenteAT);
	}

	public boolean contieneA(Terminal tdestino) {
		// TODO Auto-generated method stub
		return circuito.contieneTerminal(tdestino);
	}
}
