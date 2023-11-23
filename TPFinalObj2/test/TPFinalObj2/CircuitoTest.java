package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Terminal;
import circuito.Circuito;
import tramo.Tramo;

class CircuitoTest { //precondicion la ultima terminal se conecta con la primera
	Circuito circuito;
	List<Tramo> tramos;
	Terminal terminal2;
	Terminal terminal3;
	Terminal terminalOrigen;
	Terminal terminalUltima;
	Tramo tramo1;
	Tramo tramo2;
	Tramo tramo3;
	Tramo tramo4;
	
	@BeforeEach
	void setUp() {
		tramos = new ArrayList();
		terminal2 = mock(Terminal.class);
		terminal3 = mock(Terminal.class);
		terminalOrigen = mock(Terminal.class);
		terminalUltima = mock(Terminal.class);
		tramo1= new Tramo(terminalOrigen, terminal2, 4,4d);
		tramo2= new Tramo(terminal2, terminal3, 4,4d);
		tramo3= new Tramo(terminal3, terminalUltima, 4,4d);
		tramo4= new Tramo(terminalUltima, terminalOrigen, 4,4d);
		tramos.add(tramo1);
		tramos.add(tramo2);
		tramos.add(tramo3);
		tramos.add(tramo4);
 
		
	
		circuito = new Circuito(tramos, terminalOrigen);
	}
	
	
	@Test
	void testTiempoDesdeHastaEnHoras() {
		assertEquals(circuito.tiempoDesdeHastaEnHoras(terminal3, terminal2), 12);
	}

	@Test
	void testPrecioDesdeHasta() {
		assertEquals(circuito.precioDesdeHasta(terminal3, terminal2), 12);
	}
	
	@Test
	void testCantidadIntermediaria() {
		assertEquals(circuito.cantidadIntermediaria(terminal2, terminalUltima), 1);
	}
	
	@Test
	void testContieneATerminal() {
		assertTrue(circuito.contieneTerminal(terminal2));
	}
}
