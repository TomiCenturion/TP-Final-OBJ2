package estrategiaMejorCircuito;

import java.util.List;
import java.util.stream.Collectors;

import buque.Terminal;
import circuito.Circuito;


public class MenorTiempo extends EstrategiaMejorCircuito{

	@Override
	public Circuito mejorCircuito(List<Circuito> circuitos, Terminal t1, Terminal t2) {
		// TODO Auto-generated me
		
		//Ordena la lista de menor a mayor por los tiempos desde hasta en hs. Y toma el menor tiempo, el primero.
		return circuitos.stream()
		          .sorted((n1, n2) -> Integer.compare(
		                  n1.tiempoDesdeHastaEnHoras(t1,t2),
		                  n2.tiempoDesdeHastaEnHoras(t1,t2)))
		              .collect(Collectors.toList()).get(0);
		
		
	}

}
