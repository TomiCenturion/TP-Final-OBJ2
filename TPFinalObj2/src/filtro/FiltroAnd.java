package filtro;

import java.util.ArrayList;
import java.util.List;

import viaje.Viaje;


public class FiltroAnd implements Filtro{
	private Filtro a;
	private Filtro b;
	
	
	
	public FiltroAnd(Filtro a, Filtro b) {
		super();
		this.a = a;
		this.b = b;
	}



	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		List<Viaje> listaDeViajes = new ArrayList<Viaje>(a.filtrar(viajes));
		listaDeViajes.retainAll(b.filtrar(listaDeViajes));
		return listaDeViajes;
	}

}
