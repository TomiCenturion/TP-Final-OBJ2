package turno;

import java.time.Duration;
import java.time.LocalDateTime;

import buque.Terminal;
import operacion.Sheeper;
import viaje.Viaje;
import container.Container;


public class TurnoExportacion { //turno exportacion, tiene funcionalidades que solo son para exportar
	private Viaje viaje;
	private Sheeper sheeper;
	private LocalDateTime fechaTurno;
	private Terminal terminalLlegada;
	private Container container;
	private String conductor;
	private String camion;
	
	
	public TurnoExportacion(Viaje viaje, Sheeper sheeper, LocalDateTime fechaTurno, Terminal terminalLlegada, Container container,
			String conductor, String camion) {
		super();
		this.viaje = viaje;
		this.sheeper = sheeper;
		this.fechaTurno = fechaTurno;
		this.terminalLlegada = terminalLlegada;
		this.container = container;
		this.conductor = conductor;
		this.camion = camion;
	}
	
	
	
	public Viaje getViaje() {
		return viaje;
	}



	public Sheeper getSheeper() {
		return sheeper;
	}



	public Terminal getTerminalLlegada() {
		return terminalLlegada;
	}



	public Container getContainer() {
		return container;
	}



	public String getConductor() {
		return conductor;
	}



	public String getCamion() {
		return camion;
	}



	public boolean verificarCamionConductorYTurnoCorrecto(String conductorA, String camionB, LocalDateTime fecha) {
		long diferenciaDeHoras = Duration.between(fecha, fechaTurno).toHours();
		return conductorA == (this.conductor)  && camionB == (this.camion)  && diferenciaDeHoras < 3   ;
		}
}
