package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Terminal;
import circuito.Circuito;
import naviera.Naviera;
import viaje.Viaje;


class NavieraTest {
	List<Circuito> circuitos;
	Circuito circuitoUno;
	Circuito circuitoDos;
	Circuito circuitoTres;
	List<Viaje> viajes;
	Viaje viajeUno;
	Viaje viajeDos;
	Viaje viajeTres;
	Naviera naviera;
	Terminal terminalUno;
	Terminal terminalDos;
	
	@BeforeEach
	void setUp() {
		terminalUno = mock(Terminal.class);
		terminalDos = mock(Terminal.class);
		viajeUno = mock(Viaje.class);
		viajeDos = mock(Viaje.class);
		viajeTres = mock(Viaje.class);
		circuitoUno = mock(Circuito.class);
		circuitoDos = mock(Circuito.class);
		circuitoTres = mock(Circuito.class);
		when(circuitoUno.contieneTerminal(terminalUno)).thenReturn(true);
		when(circuitoUno.contieneTerminal(terminalDos)).thenReturn(true);
		when(circuitoDos.contieneTerminal(terminalUno)).thenReturn(true);
		when(circuitoDos.contieneTerminal(terminalDos)).thenReturn(true);
		when(circuitoTres.contieneTerminal(terminalUno)).thenReturn(true);
		when(circuitoTres.contieneTerminal(terminalDos)).thenReturn(true);
		when(circuitoUno.tiempoDesdeHastaEnHoras(terminalUno, terminalDos)).thenReturn(2);
		when(circuitoDos.tiempoDesdeHastaEnHoras(terminalUno, terminalDos)).thenReturn(5);
		when(circuitoTres.tiempoDesdeHastaEnHoras(terminalUno, terminalDos)).thenReturn(4);

		naviera = new Naviera();
		naviera.registrarCircuitos(circuitoUno);
		naviera.registrarCircuitos(circuitoTres);
		naviera.agregarViajes(viajeUno);
		naviera.agregarViajes(viajeTres);
		
	}
	
	
	

	@Test
	void puedenAgregarCircuitosALaNaviera() {
		naviera.registrarCircuitos(circuitoDos);
		assertTrue(naviera.getCircuitos().contains(circuitoDos));
	}
	@Test
	void puedenAgregarViajesALaNaviera() {
		naviera.agregarViajes(viajeDos);
		assertTrue(naviera.getViajes().contains(viajeDos));
	}

	@Test
	void mejorTiempoTest() {
		assertEquals(naviera.getMejorTiempoHasta(terminalUno, terminalDos), circuitoUno.tiempoDesdeHastaEnHoras(terminalUno, terminalDos));
	}
	
}
