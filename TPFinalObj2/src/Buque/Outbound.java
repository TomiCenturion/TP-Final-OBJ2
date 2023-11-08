package Buque;

public class Outbound extends EstadoBuque{

	@Override
	public void verificarEstado(Buque b) {
		if((b.distanciaTerrminal()) >= 50) {
			b.setEstado(new Inbound());
		}
		
	}

}
