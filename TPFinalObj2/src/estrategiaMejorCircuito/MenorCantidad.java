package estrategiaMejorCircuito;

import java.util.List;
import java.util.stream.Collectors;

import buque.Terminal;
import circuito.Circuito;


public class MenorCantidad extends EstrategiaMejorCircuito{

	@Override
	public Circuito mejorCircuito(List<Circuito> circuitos, Terminal t1, Terminal t2) {
		// TODO Auto-generated method stub
		return circuitos.stream()
		          .sorted((n1, n2) -> Integer.compare(
		                  n1.cantidadIntermediaria(t1,t2),
		                  n2.cantidadIntermediaria(t1,t2)))
		              .collect(Collectors.toList()).get(0);
	}

}
