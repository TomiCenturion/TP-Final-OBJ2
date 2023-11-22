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
	Terminal terminal1;
	Terminal terminal2;
	Viaje viaje1;
	LocalDate fecha1;
	List <Tramo> tramos;
	Tramo tramo1;
	Tramo tramo2;
	GPS ubicacion;
	GPS ubicacionDos;
	
	
	@BeforeEach
	public void setUp() {
		buque1 = mock(Buque.class);
		circuito1 = mock(Circuito.class);
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		tramo1= mock(Tramo.class);
		tramo2= mock(Tramo.class);
		fecha1= LocalDate.now();
		ubicacion = mock(GPS.class);
		ubicacionDos = mock(GPS.class);
		terminal1 = mock(Terminal.class);
		when(terminal1.getUbicacion()).thenReturn(ubicacionDos);
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(10);
		viaje1= new Viaje(buque1, fecha1, circuito1);
		circuito1.addTramo(tramo1);
		circuito1.addTramo(tramo2);
		
		
	}
	
	@Test
	public void test01() {
	
		when(tramo1.getPrecioTramo()).thenReturn(100d);
		assertEquals(viaje1.precioDesdeHasta(terminal1, terminal2),0d);
	}
	
	@Test
	public void test02() {
		when(tramo1.getTerminalSalida()).thenReturn(terminal1);
		when(tramo1.getTerminalLlegada()).thenReturn(terminal1);
		assertTrue(viaje1.contieneA(terminal2));
		
	}
	
	
}
