package Buque;


public abstract class EstadoBuque {
	public abstract void verificarEstado(Buque b);
	public void comenzarATrabajar(Buque b) {}; 
	public void finalizarTrabajo(Buque b) {};
}
