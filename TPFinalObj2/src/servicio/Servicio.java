package servicio;

import java.time.LocalDate;

public abstract class Servicio {
	private LocalDate fecha;

	public Servicio(LocalDate fecha) {
		super();
		this.fecha = fecha;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public abstract double precio();
	public int getConsumoWts() {
	return 0;
	}//metodo hook para el reefer

	
}
 