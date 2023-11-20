package filtro;

import java.util.List;

import buque.Terminal;
import viaje.Viaje;


public class FiltroPuertoDestino implements Filtro{
	private Terminal terminal;
	
	
	public FiltroPuertoDestino(Terminal terminal) {
		super();
		this.terminal = terminal;
	}


	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		// TODO Auto-generated method stub
		return viajes.stream().filter(v->v.contieneA(terminal)).toList();
	}
	
}

