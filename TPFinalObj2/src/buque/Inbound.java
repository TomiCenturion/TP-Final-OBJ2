package buque;

public class Inbound extends EstadoBuque{

	@Override
	public void verificarEstado(Buque b) {
		if(b.distanciaTerrminal() == 0) {
			b.setEstado(new Arrived());
		}
	}

}
