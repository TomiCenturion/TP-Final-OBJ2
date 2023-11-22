package viaje;

import java.time.LocalDate;
import java.util.List;

import buque.Buque;
import buque.Terminal;
import circuito.Circuito;
import naviera.TerminalGestionada;
import tramo.Tramo;

public class Viaje {
	private Buque buque;
	private LocalDate fechaSalida;
	private Circuito circuito;
	
	public Viaje(Buque buque, LocalDate fechaSalida, Circuito circuito) {
		super();
		this.buque = buque;
		this.fechaSalida = fechaSalida;
		this.circuito = circuito;
	}
	
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

	public double precioDesdeHasta(Terminal a, Terminal b) {
		return circuito.precioDesdeHasta(a, b);
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}
}
