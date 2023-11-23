package turno;

import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import operacion.Consignee;
import operacion.Importacion;


public class TurnoImportacion {
	private LocalDate horaDeLlegada;
	private Consignee consignee;
	private String conductor;
	private String camion;
	private Importacion importacion;
	
	public TurnoImportacion(LocalDate horaDeLlegada, Consignee consignee, Importacion importacion) {
		super();
		this.horaDeLlegada = horaDeLlegada;
		this.consignee = consignee;
		this.importacion = importacion;
	}


	public void setConductor(String conductor) {
		this.conductor = conductor;
	}


	public Importacion getImportacion() {
		return importacion;
	}


	public LocalDate getHoraDeLlegada() {
		return horaDeLlegada;
	}


	public Consignee getConsignee() {
		return consignee;
	}


	public void setCamion(String camion) {
		this.camion = camion;
	}
	
	public boolean verificarTurno (String camion, String conductor, ChronoLocalDate fecha){// pregunto si ya paso la hora de llegada del buque
		boolean diferenciaDeHoras = horaDeLlegada.isBefore(fecha);
		return conductor ==  this.conductor && camion == this.camion && diferenciaDeHoras    ;
	}
	 
//	para ver si se paso o cuanto se paso de la fecha
	public int verificarExcedente(ChronoLocalDate llegadaCamionConductor){
		long diferenciaDeHoras = Duration.between(llegadaCamionConductor, horaDeLlegada).toHours();
		return (int)diferenciaDeHoras/24; 
	}
	
	
}
