package TPFinalObj2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import container.Container;
import container.DryC;
import container.ReeferC;
import container.TanqueC;

class ContainerTest { 
	Container containerR;
	Container containerD;
	Container containerT;
	 
	@BeforeEach
	void setUp() {
		containerR = new ReeferC(100d,10d,2,5, 2);
		containerD = new DryC(10,20, 30, 40);
		containerT = new TanqueC(10, 15, 20, 25);
	}
	 
	
	@Test
	void cuandoPreguntoElPesoAlContainerReeferMeLoDevuelve() {
		assertEquals(containerR.getPeso(), 5);
	}
	@Test
	void cuandoPreguntoLaAlturaAlContainerReeferMeLoDevuelve() {
		assertEquals(containerR.getAltura(), 2,5);
	}
	@Test
	void cuandoPreguntoLasAlturaYElPesoAlContainerReeferMeLoDevuelve() {
		assertEquals(containerR.getAltura(), 2);
		assertEquals(containerR.getLargo(), 10);
	}
	@Test 
	void consumoDeWtsDeReefer() {
		assertEquals(containerR.getConsumoWts(), 2);
	}
	
	///
	@Test
	void cuandoPreguntoElPesoAlContainerDryMeLoDevuelve() {
		assertEquals(containerD.getPeso(), 40);
	}
	@Test
	void cuandoPreguntoLaAlturaAlContainerDryMeLoDevuelve() {
		assertEquals(containerD.getAltura(), 30);
	}
	@Test
	void cuandoPreguntoLasAlturaYElPesoAlContainerDryMeLoDevuelve() {
		assertEquals(containerD.getAncho(), 10);
		assertEquals(containerD.getLargo(), 20);
	}
	
	///
	 
	@Test
	void cuandoPreguntoElPesoAlContainerTanqueMeLoDevuelve() {
		assertEquals(containerT.getPeso(), 25);
	}
	@Test
	void cuandoPreguntoLaAlturaAlContainerTanqueMeLoDevuelve() {
		assertEquals(containerT.getAltura(), 20);
	}
	@Test
	void cuandoPreguntoLasAlturaYElPesoAlContainerTanqueMeLoDevuelve() {
		assertEquals(containerT.getAncho(), 10);
		assertEquals(containerT.getLargo(), 15);
	}
	

}
