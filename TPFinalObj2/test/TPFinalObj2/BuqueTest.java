package TPFinalObj2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Arrived;
import buque.Buque;
import buque.Departing;
import buque.EstadoBuque;
import buque.GPS;
import buque.Inbound;
import buque.Outbound;
import buque.Terminal;
import buque.Working;

public class BuqueTest {
	GPS ubicacion;
	GPS ubicacionDos;
	Terminal terminal;
	String nombre;
	Buque buque;
	
	
	@BeforeEach
	void setUp() {
		ubicacion = mock(GPS.class);
		ubicacionDos = mock(GPS.class);
		terminal = mock(Terminal.class);
		when(terminal.getUbicacion()).thenReturn(ubicacionDos);
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(10);
		buque = new Buque(ubicacion,terminal,"messi");
	} 
	
	
	//outbound test
	@Test
	void cuandoElBuqueSeEcncuentraLejosDeLaTerminalSuEstadoEsOutbound() {
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(2);
		buque.verificarEstado();
		assertEquals(buque.getEstado().getClass(),Outbound.class);
	}
	
	//inbound test

	@Test
	void cuandoElBuqueSeEcncuentraLA50kmSuEstadoPasaAInbound() {
		 when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(50);
	        buque.verificarEstado();
	        buque.verificarEstado();
	        assertEquals(buque.getEstado().getClass(), Inbound.class);
	
	} 
//	
//	//arrived test
//
	@Test
	void cuandoElBuqueSTieneLasMismasCoordenadasQueLaTerminalPasaAArrived() {
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(50);
        buque.verificarEstado();
        buque.verificarEstado();
        when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(0);
        buque.verificarEstado();
        
        
        assertEquals(buque.getEstado().getClass(), Arrived.class);
	}
	@Test
	void elBuquePasaDeArrivedAWorking() {
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(50);
        buque.verificarEstado();
        buque.verificarEstado();
        when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(0);
        buque.verificarEstado();
        buque.comenzarATrabajar();
        buque.finalizarTrabajo();
        buque.verificarEstado();
        buque.verificarEstado();


        
        assertEquals(buque.getEstado().getClass(), Departing.class);
	}
	//22/11
	@Test
	void elBuquePasaDeWorkingADeparting() {
		when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(50);
        buque.verificarEstado();
        buque.verificarEstado();
        when(ubicacion.distanciaHasta(ubicacionDos)).thenReturn(0);
        buque.verificarEstado();
        buque.comenzarATrabajar();
        buque.finalizarTrabajo();
        buque.verificarEstado();

        
        assertEquals(buque.getEstado().getClass(), Departing.class);
	}
	
	
	
}

