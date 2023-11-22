package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    	importacion.agregarServicios(servicioUno);
    	importacion.agregarServicios(servicioDos);
    	importacion.agregarServicios(servicioTres);
    	importacion.agregarServicios(servicioCuatro);
    	
    	exportacion.agregarServicios(servicioUno);
    	exportacion.agregarServicios(servicioDos);
    	exportacion.agregarServicios(servicioTres);
    	exportacion.agregarServicios(servicioCuatro);
    	
	
    	
    }

	@Test
	void testPrecioImportacion() {
		assertEquals(servicioUno.precio() +servicioDos.precio() + servicioTres.precio() + servicioCuatro.precio() + viaje.precioDesdeHasta(terminal1, terminal2) , importacion.precio());
	}
	@Test
	void testPrecioExportacion() {
		assertEquals(servicioUno.precio() +servicioDos.precio() + servicioTres.precio() + servicioCuatro.precio() , exportacion.precio());
	}

}