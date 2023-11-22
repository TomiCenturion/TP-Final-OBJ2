package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FacturaTest {
	List<Servicio> servicios;
	Servicio servicioUno;
    Servicio servicioDos;
    Servicio servicioTres;
    Servicio servicioCuatro;
    Factura factura;
    
    
    
	@BeforeEach
	void setUp(){
		servicios = new ArrayList<>();
		servicioUno = mock(Servicio.class);
    	servicioDos = mock(Servicio.class);
    	servicioTres = mock(Servicio.class);
    	servicioCuatro = mock(Servicio.class);
    	
    	servicios.add(servicioUno);
    	servicios.add(servicioDos);
    	servicios.add(servicioTres);
    	servicios.add(servicioCuatro);
    	
    	factura = new Factura(servicios, 14000);
    	
	}
	
	
	@Test
	void aUnaFacturaSeLePuedenPedirLosServicios() {
		assertEquals(factura.getServicios(), servicios);
	}

	@Test
	void aUnaFacturaSeLePuedenPedirElPrecioTotal() {
		assertEquals(factura.getPrecioTotal(), 14000);
	}
