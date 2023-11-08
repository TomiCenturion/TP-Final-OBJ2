package tramo;

import buque.Terminal;

public class Tramo {
	private Terminal terminalSalida;
	private Terminal terminalLlegada;
	private int tiempoEstimadoEnHoras;
	private double precioTramo;
	
	public int getTiempoEstimadoEnHoras() {
		return tiempoEstimadoEnHoras;
	}

	public double getPrecioTramo() {
		return precioTramo;
	}

	public Tramo(Terminal terminalSalida, Terminal terminalLlegada, int tiempoEstimadoEnHoras) {
		super();
		this.terminalSalida = terminalSalida;
		this.terminalLlegada = terminalLlegada;
		this.tiempoEstimadoEnHoras = tiempoEstimadoEnHoras;
	}

	public boolean tieneLaTerminal(Terminal terminalGestionada) {
		// TODO Auto-generated method stub
		return terminalLlegada == terminalGestionada;
	}

	public double precio() {
		// TODO Auto-generated method stub
		return precioTramo;
	}

	public Terminal getTerminalSalida() {
		return terminalSalida;
	}

	public Terminal getTerminalLlegada() {
		return terminalLlegada;
	}
	
	
	
}
