package buque;

public class Working extends EstadoBuque{

	@Override
	public void verificarEstado(Buque b) {		
	};

	public void finalizarTrabajo(Buque b) {
		b.setEstado(new Departing());
	}
}
