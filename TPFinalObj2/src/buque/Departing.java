package buque;

public class Departing extends EstadoBuque {

	@Override
	public void verificarEstado(Buque b) {
		if(b.distanciaTerrminal() > 1) {
			b.setEstado(new Outbound());
			b.enviarMailSalida();
		}
		
	}

}
