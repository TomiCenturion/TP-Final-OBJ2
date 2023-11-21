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
	
	public GPS getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(GPS ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	public EstadoBuque getEstado() {
		return estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
