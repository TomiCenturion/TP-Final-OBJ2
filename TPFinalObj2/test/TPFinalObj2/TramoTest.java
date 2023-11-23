package TPFinalObj2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import buque.GPS;
import buque.Terminal;
import tramo.Tramo;

public class TramoTest {
	
	Terminal terminal1;
	Terminal terminal2;
	GPS ubicacionSalida;
	GPS ubicacionLlegada;
	Tramo tramo1;

	
	@BeforeEach
	public void setUp() {
		ubicacionSalida= mock(GPS.class);
		ubicacionLlegada = mock(GPS.class);
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(terminal1.getUbicacion()).thenReturn(ubicacionSalida);
		when(terminal2.getUbicacion()).thenReturn(ubicacionLlegada);
		
		tramo1= new Tramo(terminal1, terminal2, 4,4d);
		
	}
	
	@Test
	public void test01UnTramoTieneUnaTerminalDeLlegada() {
		assertTrue(tramo1.tieneLaTerminal(terminal2));
	}
	
	
	@Test 
	public void test02UnTramoNoTieneUnaTerminalDeLLegada() {
		assertTrue(tramo1.tieneLaTerminal(terminal1));
	}
	
	@Test 
	public void test03() {
		assertEquals(tramo1.getTerminalLlegada(), terminal2);
	}
	
	@Test
	public void test04() {
		assertEquals(tramo1.getTerminalSalida(), terminal1);
	}
	
	
	@Test
	public void test05UnTramoTieneUnTiempoEstimadoEnHoras() {
		assertEquals(tramo1.getTiempoEstimadoEnHoras(), 4);
	}
	
	@Test
	public void cuandoPidoElPrecioDelTramoMeDevuelveElCorrecto() {
		assertTrue(tramo1.getPrecioTramo() == 4d);
	}
	
	
}
