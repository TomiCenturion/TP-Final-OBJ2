package TPFinalObj2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.GPS;
import buque.Terminal;
import circuito.Circuito;
import viaje.Viaje;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import tramo.Tramo;

public class ViajeTest {

	Buque buque1;
	Circuito circuito1;
	Terminal terminalOrigen;
	Terminal terminal2;
	Viaje viaje1;
	LocalDate fecha1;
	List <Tramo> tramos;
	GPS ubicacion;
	GPS ubicacionDos;
	
	
	@BeforeEach
	public void setUp() {
		buque1 = mock(Buque.class);
		circuito1 = mock(Circuito.class);
		terminalOrigen = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		fecha1= LocalDate.now();
		ubicacion = mock(GPS.class);
		ubicacionDos = mock(GPS.class);
		when(terminalOrigen.getUbicacion()).thenReturn(ubicacionDos);
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(10);
		when(circuito1.tiempoDesdeHastaEnHoras(terminalOrigen, terminal2)).thenReturn(28);
		when(circuito1.contieneTerminal(terminal2)).thenReturn(true);
		when(circuito1.precioDesdeHasta(terminalOrigen, terminal2)).thenReturn(1000d);
		when(circuito1.getTerminalOrigen()).thenReturn(terminalOrigen);
		viaje1= new Viaje(buque1, fecha1, circuito1); 
		
	}
		@Test
		void pruebaDeFechaDeSalidaDe() {
			assertEquals(viaje1.fechaDeSalidaDe(terminal2), viaje1.getFechaSalida().plusDays(circuito1.tiempoDesdeHastaEnHoras(terminalOrigen, terminal2)/24));
		
		 
		
	}
     @Test
     void testeoDeContieneATerminal() {
    	 assertTrue(viaje1.contieneA(terminal2));
     }
		
     @Test
     void testoDeprecioDesdeHasta() {
    	 assertEquals(viaje1.precioDesdeHasta(terminalOrigen, terminal2), 1000);
     }
	
		
	@Test
	void unViajeTieneUnBuque() {
		assertEquals(viaje1.getBuque(), buque1);
	}
     
     

//
//		public double precioDesdeHasta(Terminal a, Terminal b) {
//			return circuito.precioDesdeHasta(a, b);
//		}

	
	
	
}
