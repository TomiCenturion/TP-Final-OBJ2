package filtro;

import java.time.LocalDate;
import java.util.List;

import viaje.Viaje;



public class FiltroFechaDeSalida implements Filtro{
	private LocalDate fecha;
	
	public  FiltroFechaDeSalida(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
	
		return viajes.stream().filter(v->v.getFechaSalida().equals(fecha) ).toList();
	}

}
