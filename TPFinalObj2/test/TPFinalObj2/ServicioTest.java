package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import servicio.Almacenamiento;
import servicio.Electricidad;
import servicio.Lavado;
import servicio.Pesado; 
import servicio.Servicio;

class ServicioTest {
	Servicio servicioLavadoExcedido;
	Servicio servicioLavado;
	LocalDate fecha;
	Servicio servicioPesado;
	Servicio servicioElectricidad;
	LocalDateTime fechaInicio;
	LocalDateTime fechaFin;
	Servicio servicioAlmacenamiento;
	
	@BeforeEach
	void setUp() {
		fecha = LocalDate.now();
		fechaInicio = LocalDateTime.of(2023, 11, 10, 8, 15);
		fechaInicio = LocalDateTime.of(2023, 11, 30, 8, 15);
		servicioLavadoExcedido = new Lavado(12000, 12500, 100, fecha);
		servicioLavado= new Lavado(12000, 12500, 30, fecha);
		servicioPesado = new Pesado(200, 590, fecha);
		servicioElectricidad = new Electricidad(120, fechaInicio, null, 3, fecha);
		servicioAlmacenamiento = new  Almacenamiento(20,30, fecha);
	} 
	
	@Test
	void testPrecioDeLavadoCapacidadExcedidad() {
		assertEquals(servicioLavadoExcedido.precio(), 12500);
	}
	@Test
	void testPrecioDeLavadoCapacidadNormal() {
		assertEquals(servicioLavado.precio(), 12000);
	}
	@Test
	void cuandoLePidoLaFechaDelLavadoMeLaDevueve() {
		assertTrue(servicioLavado.getFecha() == fecha);
	}
	@Test
	void cuandoPreguntoElPrecioDeElectricidadEs60120() {
		assertEquals(Math.round(servicioElectricidad.precio()),-58320);
	}
	@Test
	void cuandoLePidoElPrecioAUnServicioPesadoMeLoDevuelve() {
		assertEquals(servicioPesado.precio(), 590);
	}
	@Test
	void cuandoLePidoElPrecioAUnsServicioPesadoMeLoDevuelve() {
		assertEquals(servicioPesado.getFecha(), fecha);
	}
	
	
	
	@Test
	void precioPorDiasDeAlmacenamiento() {
		assertEquals(servicioAlmacenamiento.precio(), 600);
	}
	

}
