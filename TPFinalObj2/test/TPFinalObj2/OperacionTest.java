package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Terminal;
import container.Container;
import operacion.Consignee;
import operacion.Exportacion;
import operacion.Importacion;
import operacion.Sheeper;
import servicio.Servicio;
import turno.TurnoImportacion;
import viaje.Viaje;


class OperacionTest {
	List<Servicio> servicios;
	Viaje viaje;
	Container container;
    LocalDate fecha;
    Servicio servicioUno;
    Servicio servicioDos;
    Servicio servicioTres;
    Servicio servicioCuatro;
    Importacion importacion;
    Exportacion exportacion;
    Consignee consignee;
    Terminal terminal1;
    Terminal terminal2;
    Sheeper sheeper;
    

    @BeforeEach
    void setUp() {
    
    	terminal1 = mock(Terminal.class);
    	terminal2 = mock(Terminal.class);
    	fecha = LocalDate.of(2023, 11, 22);
    	container = mock(Container.class);
    	when(container.getPeso()).thenReturn(100d);
    	viaje = mock(Viaje.class);
    	when(viaje.precioDesdeHasta(terminal1, terminal2)).thenReturn(100d);
    	sheeper = mock(Sheeper.class);
    	exportacion = new Exportacion(viaje, sheeper, terminal2, terminal1, container, fecha);
    	importacion = new Importacion(viaje,consignee,terminal1,terminal2,container, fecha );
    	consignee = mock(Consignee.class);
    	servicioUno = mock(Servicio.class);
    	servicioDos = mock(Servicio.class);
    	servicioTres = mock(Servicio.class);
    	servicioCuatro = mock(Servicio.class);
    	
    	
    
    	 
    	when(servicioUno.precio()).thenReturn(10d);
    	when(servicioDos.precio()).thenReturn(10d);
    	when(servicioTres.precio()).thenReturn(10d);
    	when(servicioCuatro.precio()).thenReturn(10d);
    	importacion.agregarServicio(servicioUno);
    	importacion.agregarServicio(servicioDos);
    	importacion.agregarServicio(servicioTres);
    	importacion.agregarServicio(servicioCuatro);
    	
    	exportacion.agregarServicio(servicioUno);
    	exportacion.agregarServicio(servicioDos);
    	exportacion.agregarServicio(servicioTres);
    	exportacion.agregarServicio(servicioCuatro);
    	
	
    	
    }

	@Test
	void testPrecioImportacion() {
		assertEquals(servicioUno.precio() +servicioDos.precio() + servicioTres.precio() + servicioCuatro.precio() + viaje.precioDesdeHasta(terminal1, terminal2) , importacion.precio());
	}
	@Test
	void testPrecioExportacion() {
		assertEquals(servicioUno.precio() +servicioDos.precio() + servicioTres.precio() + servicioCuatro.precio() , exportacion.precio());
	}
	
	
	 @Test
	    void verificarExcedenteTest() {
	        // Crear un mock para ChronoLocalDate
	        ChronoLocalDate llegadaCamionConductorMock = mock(ChronoLocalDate.class);
	        when(llegadaCamionConductorMock.isBefore(any())).thenReturn(true);

	        // Crear un objeto TurnoImportacion con valores específicos
	        LocalDate horaDeLlegada = LocalDate.now();
	        TurnoImportacion turnoImportacion = new TurnoImportacion(horaDeLlegada, mock(Consignee.class), mock(Importacion.class));

	        // Llamar al método que deseas probar
	        int resultado = turnoImportacion.verificarExcedente(llegadaCamionConductorMock);

	        // Verificar el resultado esperado (en este ejemplo, asumimos que el resultado es 0)
	        assertEquals(0, resultado);
	    }

}
