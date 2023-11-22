package operacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import buque.Terminal;
import operacion.Sheeper;
import servicio.Servicio;
import container.Container;
import factura.Factura;
import viaje.Viaje;

public class Exportacion extends Operacion {
	
	private Sheeper sheeper;
    private Terminal tdestino;
    private Terminal tOrigen;
    private List<Servicio> servicios;

 
	 public Exportacion(Viaje viaje, Sheeper sheeper, Terminal tOrigen, Terminal tdestino, Container contenedor, LocalDate fecha) {
	        super(viaje,contenedor,fecha);
	        this.sheeper = sheeper;
	        this.tOrigen = tOrigen;
	        this.tdestino = tdestino;
	        this.servicios = new ArrayList<Servicio>();
	}

	@Override
	public double costoAdicional() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enviarFactura() {
		this.sheeper.enviarFactura(new Factura(this.getServicios(),this.precio()));
	}
	
	@Override
    public void enviarMailSheeper(String mail) {
        sheeper.enviarMail(mail);
    }
	
	@Override
	public List <Servicio> getServicios(){
		return servicios;
	}

	@Override
	public void agregarServicio(Servicio servicio) {
		this.getServicios().add(servicio);
	}

}
