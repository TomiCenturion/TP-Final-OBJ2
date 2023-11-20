package buque;

public class Buque{
	private EstadoBuque estado;
	private GPS ubicacion;
	private Terminal terminal;
	private String nombre;

	public void verificarEstado() {
		this.estado.verificarEstado(this);
	}

	public void setEstado(EstadoBuque estado) {
		this.estado = estado;
	}

	public int distanciaTerrminal() {
		// TODO Auto-generated method stub
		return ubicacion.distanciaHasta(terminal.getUbicacion());
	}
	
	public void enviarMailLlegada() {
		terminal.enviarMailATodosConsignee(this);
	}
	public void enviarMailSalida() {
		terminal.enviarMailATodosSheepers(this);
	}
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public void comenzarATrabajar() {
		this.estado.comenzarATrabajar(this);
	}

	public void finalizarTrabajo() {
		this.estado.finalizarTrabajo(this);
		
	}
	
}
