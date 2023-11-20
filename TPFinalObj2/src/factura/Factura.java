package factura;

import java.util.List;

import servicio.Servicio;

public class Factura {
	private List<Servicio> servicios;
	private double precioTotal;
	public Factura(List<Servicio> servicios, double precioTotal) {
		super();
		this.servicios = servicios;
		this.precioTotal = precioTotal;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	
	
}

