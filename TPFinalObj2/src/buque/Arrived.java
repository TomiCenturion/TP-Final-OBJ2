package buque;

public class Arrived extends EstadoBuque{

	@Override
	public void verificarEstado(Buque b) {}

	public void comenzarATrabajar(Buque b) {
		b.setEstado(new Working());
	}; 
}
