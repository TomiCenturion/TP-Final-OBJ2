package tramo;

import buque.Terminal;

public class Tramo {
	private Terminal terminalSalida;
	private Terminal terminalLlegada;
	private int tiempoEstimadoEnHoras;
	private double precioTramo;
	
	
	
	
	public Tramo(Terminal terminalSalida, Terminal terminalLlegada, int tiempoEstimadoEnHoras, double precioTramo) {
		super();
		this.terminalSalida = terminalSalida;
		this.terminalLlegada = terminalLlegada;
		this.tiempoEstimadoEnHoras = tiempoEstimadoEnHoras;
		this.precioTramo = precioTramo;
	}

	public int getTiempoEstimadoEnHoras() {
		return tiempoEstimadoEnHoras;
	}

	public double getPrecioTramo() {
		return precioTramo;
	}


	public boolean tieneLaTerminal(Terminal terminalGestionada) {
		// TODO Auto-generated method stub
		return terminalLlegada == terminalGestionada || terminalSalida == terminalGestionada;
	}

	public Terminal getTerminalSalida() {
		return terminalSalida;
	}

	public Terminal getTerminalLlegada() {
		return terminalLlegada;
	}
	
	
	
}
