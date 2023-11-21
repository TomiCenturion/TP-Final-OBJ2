package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import buque.Buque;
import buque.GPS;
import buque.Terminal;
import circuito.Circuito;
import container.Container;
import estrategiaMejorCircuito.EstrategiaMejorCircuito;
import naviera.Naviera;
import naviera.TerminalGestionada;
import operacion.Consignee;
import operacion.Sheeper;
import viaje.Viaje;

class TerminalGestionadaTest {
	TerminalGestionada terminal;
	Buque buque;
	EstrategiaMejorCircuito estrategia;
	Naviera navieraUno;
	Naviera navieraDos;
	Naviera navieraTres;
	GPS ubicacion;
	GPS ubicacion2;
	Circuito circuitoUno;
	Circuito circuitoDos;
	Circuito circuitoTres;
	Circuito circuitoCuatro;
	Terminal terminalExterna;
	Container container;
	Sheeper sheeper;
	Viaje viaje;
	Viaje viaje2;
	Viaje viaje3;
	Viaje viaje4;
	Consignee consignee;
	LocalDate fechaPrueba;
	LocalDateTime fechaPruebaDos;
	

	
	@BeforeEach
	
	void setUp() {
		fechaPrueba = LocalDate.of(2023,11,10);
		fechaPruebaDos = LocalDateTime.of(2023, 11, 10, 10, 10);
		estrategia = new MenorTiempo();
		ubicacion = mock(GPS.class);
		ubicacion2= mock(GPS.class);
		when(ubicacion.distanciaHasta(ubicacion2)).thenReturn(50);
		terminal = new TerminalGestionada(estrategia,ubicacion);
		terminalExterna = mock(Terminal.class);
		buque = mock(Buque.class);
		when(buque.distanciaTerrminal()).thenReturn(50);
		navieraUno = mock(Naviera.class);
		navieraDos = mock(Naviera.class);
		navieraTres = mock(Naviera.class);
		terminal.registrarNaviera(navieraUno);
		terminal.registrarNaviera(navieraDos);
		terminal.registrarNaviera(navieraTres);
		circuitoUno = mock(Circuito.class);
		circuitoDos = mock(Circuito.class);
		circuitoTres = mock(Circuito.class);
		circuitoCuatro = mock(Circuito.class);
		consignee = mock(Consignee.class);
		sheeper = mock(Sheeper.class);
		container = mock(Container.class);
		viaje = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
		viaje3 = mock(Viaje.class);
		viaje4 = mock(Viaje.class);
		when(viaje.getBuque()).thenReturn(buque);
		
		when(navieraUno.getCircuito(terminal)).thenReturn(List.of(circuitoUno,circuitoDos));
		when(navieraDos.getCircuito(terminal)).thenReturn(List.of(circuitoTres));
		when(navieraTres.getCircuito(terminal)).thenReturn(List.of(circuitoCuatro));
		
		when(navieraUno.getViajes()).thenReturn(List.of(viaje,viaje2));
		when(navieraDos.getViajes()).thenReturn(List.of(viaje3));
		when(navieraTres.getViajes()).thenReturn(List.of(viaje4));

		when(viaje.contieneA(terminal)).thenReturn(true);
		when(viaje2.contieneA(terminal)).thenReturn(true);
		when(viaje3.contieneA(terminal)).thenReturn(true);
		when(viaje4.contieneA(terminal)).thenReturn(false);
		when(viaje.contieneA(terminalExterna)).thenReturn(true);
		when(viaje2.contieneA(terminalExterna)).thenReturn(true);
		when(viaje3.contieneA(terminalExterna)).thenReturn(false);
		when(viaje4.contieneA(terminalExterna)).thenReturn(true);
		when(viaje.fechaDeSalidaDe(terminal)).thenReturn(LocalDate.of(2023, 11, 17));
		when(viaje2.fechaDeSalidaDe(terminal)).thenReturn(LocalDate.of(2023, 11, 18));
		when(viaje3.fechaDeSalidaDe(terminal)).thenReturn(LocalDate.of(2023, 11, 17));
		when(viaje4.fechaDeSalidaDe(terminal)).thenReturn(LocalDate.of(2023, 11, 18));
		
		when(viaje3.getFechaSalida()).thenReturn(LocalDate.of(2023, 11, 17));
		when(viaje4.getFechaSalida()).thenReturn(LocalDate.of(2023, 11, 17));
		when(viaje.getFechaSalida()).thenReturn(LocalDate.of(2023, 11, 17));
		when(viaje2.getFechaSalida()).thenReturn(LocalDate.of(2023, 11, 18));
		
		when(navieraUno.getMejorTiempoHasta(terminal,terminalExterna)).thenReturn(2);
		when(navieraDos.getMejorTiempoHasta(terminal,terminalExterna)).thenReturn(3);
		when(navieraTres.getMejorTiempoHasta(terminal,terminalExterna)).thenReturn(4);

		
		when(circuitoUno.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(4);
		when(circuitoDos.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(5);
		when(circuitoTres.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(6);
		when(circuitoCuatro.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(7);
		
		
		when(circuitoUno.contieneTerminal(terminalExterna)).thenReturn(true);
		when(circuitoDos.contieneTerminal(terminalExterna)).thenReturn(true);
		when(circuitoTres.contieneTerminal(terminalExterna)).thenReturn(true);
		when(circuitoCuatro.contieneTerminal(terminalExterna)).thenReturn(true);	
		
		when(circuitoUno.contieneTerminal(terminal)).thenReturn(true);
		when(circuitoDos.contieneTerminal(terminal)).thenReturn(true);
		when(circuitoTres.contieneTerminal(terminal)).thenReturn(true);
		when(circuitoCuatro.contieneTerminal(terminal)).thenReturn(true);	
		
		
	
	}
	
	
	
	@Test
	void testDistanciaTerminal() {
		
		assertEquals(buque.distanciaTerrminal(), 50);
	}
	
	@Test

	void testEstrategiaMejorCircuitoMenorTiempo() {
		
		
		assertEquals(terminal.mejorCircuito(terminalExterna), circuitoUno);

	}
	
	@Test

	void testEstrategiaMejorCircuitoMenorPrecio() {
		this.terminal.setEstrategia(new MenorPrecio());
		
		when(circuitoUno.precioDesdeHasta(terminal, terminalExterna)).thenReturn(4000d);
		when(circuitoDos.precioDesdeHasta(terminal, terminalExterna)).thenReturn(500d);
		when(circuitoTres.precioDesdeHasta(terminal, terminalExterna)).thenReturn(62000d);
		when(circuitoCuatro.precioDesdeHasta(terminal, terminalExterna)).thenReturn(74d);
		assertEquals(terminal.mejorCircuito(terminalExterna), circuitoCuatro);
	}
	
	@Test

	void testEstrategiaMejorCircuitoMenorCantidad() {
		this.terminal.setEstrategia(new MenorCantidad());
		
		when(circuitoUno.cantidadIntermediaria(terminal, terminalExterna)).thenReturn(4000);
		when(circuitoDos.cantidadIntermediaria(terminal, terminalExterna)).thenReturn(50);
		when(circuitoTres.cantidadIntermediaria(terminal, terminalExterna)).thenReturn(60);
		when(circuitoCuatro.cantidadIntermediaria(terminal, terminalExterna)).thenReturn(74);
		assertEquals(terminal.mejorCircuito(terminalExterna), circuitoDos);
	}
 
	@Test
	void testProximaFechaDesdeTerminalAATerminalB (){
		LocalDate fecha = LocalDate.of(2023, 11, 17);
		assertEquals(terminal.proximaFechaHastaTerminalDestino(terminal,fecha), fecha.plusDays(circuitoUno.tiempoDesdeHastaEnHoras(terminal, terminalExterna)/24));
	}
	
	@Test 
	void testExportacion() {
		assertEquals(terminal.getTurnoExportacion().size(), 0);
		LocalDateTime fecha = LocalDateTime.of(2023,11, 16, 16, 43);
		terminal.exportar(container, sheeper, "nhm510", "Messi", terminalExterna, viaje, fecha);
		assertEquals(terminal.getTurnoExportacion().size(), 1);
		assertTrue(terminal.getTurnoExportacion().stream().anyMatch(e->e.verificarCamionConductorYTurnoCorrecto("Messi", "nhm510", fecha)));
	}
	
	@Test 
	void testEntregaCargaTerrestre() {
		LocalDateTime fecha = LocalDateTime.of(2023,11, 16, 16, 43);
		assertEquals(terminal.getOperaciones().get(buque),null);
		terminal.exportar(container, sheeper, "nhm510", "Messi", terminalExterna, viaje, fecha);
		assertEquals(terminal.getTurnoExportacion().size(), 1);
		try {terminal.entregarCargaTerrestre("nhm510", "Messi", container,fecha);}catch (Exception ignore){
			
		}
		assertEquals(terminal.getTurnoExportacion().size(), 0);
		assertNotEquals(terminal.getOperaciones().get(buque),null);
		assertEquals(terminal.getOperaciones().get(buque).size(),1);
	}
	
	@Test 
	void testHaEmpezadoATrabajar() {
		terminal.empezarATrabajar(buque);
		verify(buque).comenzarATrabajar();
	}
	
	@Test
	void testHaTerminadoDeTrabajar() {
		terminal.terminarDeTrabajar(buque); 
		verify(buque).finalizarTrabajo();
	}
	
	@Test 
	void testTiempoDeLlegadaDeTGestionadaAOtraTerminal(){
		when(circuitoUno.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(4);
		when(circuitoDos.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(5);
		when(circuitoTres.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(6);
		when(circuitoCuatro.tiempoDesdeHastaEnHoras(terminal, terminalExterna)).thenReturn(7);
		
		assertEquals(terminal.tiempoDeLlegadaDeTGestionadaAOtraTerminal(terminalExterna),2);
	}
	
	@Test 
	void testImportacion() {
		assertEquals(terminal.getTurnosImportacion().size(), 0);
		LocalDate fecha = LocalDate.of(2023,11, 17);
		terminal.importar(consignee,terminalExterna,viaje,container,fecha);
		assertEquals(terminal.getTurnosImportacion().size(), 1);
		assertEquals(terminal.getTurnosImportacion().get(0).getHoraDeLlegada(),LocalDate.of(2023,11, 17));
	}
	
	@Test 
	void testFechaDeBuqueHasta() {
		
		assertEquals(terminal.fechaBuqueHasta(terminalExterna),LocalDate.of(2023, 11, 17) );
		
	}
	
	
	//PARA TESTEAR EN OTRO PACKAGE FILTRO
	
	@Test
	void testDeFiltradoFechaSalida() {
		LocalDate fecha = LocalDate.of(2023, 11,17);
		assertTrue(terminal.filtrarViajes(new FiltroFechaDeSalida(fecha)).contains(viaje));
		assertTrue(terminal.filtrarViajes(new FiltroFechaDeSalida(fecha)).contains(viaje3));
		assertFalse(terminal.filtrarViajes(new FiltroFechaDeSalida(fecha)).contains(viaje2));

	}
	@Test
	void testDeFiltradoFechaLlegada() {
		LocalDate fecha = LocalDate.of(2023, 11,17);
		assertTrue(terminal.filtrarViajes(new FiltroFechaDeLlegada(fecha,terminal)).contains(viaje));
		assertTrue(terminal.filtrarViajes(new FiltroFechaDeLlegada(fecha,terminal)).contains(viaje3));
		assertFalse(terminal.filtrarViajes(new FiltroFechaDeLlegada(fecha,terminal)).contains(viaje2));
		assertFalse(terminal.filtrarViajes(new FiltroFechaDeLlegada(fecha,terminal)).contains(viaje4));
	}
	
	@Test
	void testDeFiltradoPuertoDestino() {
		assertTrue(terminal.filtrarViajes(new FiltroPuertoDestino(terminal)).contains(viaje));
		assertTrue(terminal.filtrarViajes(new FiltroPuertoDestino(terminal)).contains(viaje3));
		assertTrue(terminal.filtrarViajes(new FiltroPuertoDestino(terminal)).contains(viaje2));
		assertFalse(terminal.filtrarViajes(new FiltroPuertoDestino(terminal)).contains(viaje4));
	}
	
	@Test
	void testDeFiltradoAND() {
		Filtro destino = new FiltroPuertoDestino(terminal);
		Filtro salida = new FiltroFechaDeSalida(LocalDate.of(2023, 11,17));
		Filtro and = new FiltroAnd(salida, destino);
		
		assertTrue(terminal.filtrarViajes(and).contains(viaje));
		assertTrue(terminal.filtrarViajes(and).contains(viaje3));
		assertFalse(terminal.filtrarViajes(and).contains(viaje2));
		assertFalse(terminal.filtrarViajes(and).contains(viaje4));
	}
	//or
//	@Test
//	void testDeFiltradoAND() {
//		Filtro destino = new FiltroPuertoDestino(terminal);
//		Filtro salida = new FiltroFechaDeSalida(LocalDate.of(2023, 11,17));
//		Filtro and = new FiltroAnd(salida, destino);
//		
//		assertTrue(terminal.filtrarViajes(and).contains(viaje));
//		assertTrue(terminal.filtrarViajes(and).contains(viaje3));
//		assertFalse(terminal.filtrarViajes(and).contains(viaje2));
//		assertFalse(terminal.filtrarViajes(and).contains(viaje4));
//	}
	
	@Test
	void testDeEnvioDeEmailAConsignee() {
		terminal.importar(consignee, terminal, viaje, container, fechaPrueba);
		terminal.exportar(container, sheeper, "Messi", "il394", terminal, viaje, fechaPruebaDos);
		try {
			terminal.entregarCargaTerrestre("ils394", "Messi", container, fechaPruebaDos);
		}catch (Exception e){
			
		}
		terminal.enviarMailATodosConsignee(buque);
		verify(consignee).enviarMail("La carga esta llegando La fecha es: " + viaje.fechaDeSalidaDe(terminal) );
		verifyNoInteractions(sheeper);
	}
	 
	//verificar expecion
	@Test
	void testDeEnvioDeEmailASheeper() {
		terminal.importar(consignee, terminal, viaje, container, fechaPrueba);
		terminal.exportar(container, sheeper, "il394","Messi", terminalExterna, viaje, fechaPruebaDos);
//		assertThrows(Exception.class,()->{ terminal.entregarCargaTerrestre(null,null, container, fechaPruebaDos);});
		try {
			terminal.entregarCargaTerrestre("il394", "Messi", container, fechaPruebaDos);
		}catch (Exception e){
		}
		terminal.enviarMailATodosSheepers(buque);
		verify(sheeper).enviarMail("La carga esta saliendo");;
		verifyNoInteractions(consignee);
	}
	 
	@Test
	void testDeEnvioDeFactura() {
		
		terminal.importar(consignee, terminal, viaje, container, fechaPrueba);
		terminal.exportar(container, sheeper,"ils394","Messi", terminal, viaje, fechaPruebaDos);

		assertDoesNotThrow(()->{terminal.entregarCargaTerrestre("ils394", "Messi", container, fechaPruebaDos);}, "El turno no ha sido verificado");
		assertEquals(terminal.getOperaciones().get(buque).size(), 2);
		
		terminal.enviarFactura(buque);
		verify(consignee).enviarFactura(any(Factura.class));
		verify(sheeper).enviarFactura(any(Factura.class));
	}
	 
	@Test
	void testDeRetiroDeCarga() {
		terminal.importar(consignee, terminal, viaje, container, fechaPrueba);
		assertEquals(terminal.getTurnosImportacion().size(),1);	
		
		assertDoesNotThrow(()->{terminal.registrarCamionYConductor(consignee, "ils394", "messi", viaje.fechaDeSalidaDe(terminal));
			terminal.retirarCarga("ils394","messi",   viaje.fechaDeSalidaDe(terminal));});
//		assertEquals(terminal.getTurnosImportacion().size(),0);	

	}
	
} 

