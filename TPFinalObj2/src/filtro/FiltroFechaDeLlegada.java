package filtro;

import java.time.LocalDate;
import java.util.List;

import buque.Terminal;
import viaje.Viaje;


public class FiltroFechaDeLlegada implements Filtro{
	private LocalDate fecha;
	private Terminal terminalDeLlegada;
	
	public  FiltroFechaDeLlegada(LocalDate fecha, Terminal terminalDeLlegada) {
		this.fecha = fecha;
		this.terminalDeLlegada = terminalDeLlegada;
	}
	

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
	
		return viajes.stream().filter(v->v.fechaDeSalidaDe(terminalDeLlegada).equals(fecha)).toList();
	}

}
