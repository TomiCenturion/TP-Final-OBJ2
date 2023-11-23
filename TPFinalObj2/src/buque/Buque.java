package buque;


public class Buque{
	private EstadoBuque estado;
	private GPS ubicacion;
	private Terminal terminal;
	private String nombre;

	public Buque(GPS ubicacion, Terminal terminal, String nombre) {
		super();
		this.setEstado(new Departing());//precondicion un buque arranca siempre saliendo de una terminal vacio	
		this.ubicacion = ubicacion;
		this.terminal = terminal;
		this.nombre = nombre;
		
	}

	public EstadoBuque getEstado() {
		return estado;
	}

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
	
	
	public String getNombre() {
		return nombre;
	}

	public void enviarMailLlegada() {
		terminal.enviarMailATodosConsignee(this);
	}
	public void enviarMailSalida() {
		terminal.enviarMailATodosSheepers(this);
	}

	public void comenzarATrabajar() {
		this.estado.comenzarATrabajar(this);
	}

	public void finalizarTrabajo() {
		this.estado.finalizarTrabajo(this);
		
	}
	
}
