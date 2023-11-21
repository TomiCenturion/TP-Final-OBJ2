package operacion;
import java.time.LocalDate;

import buque.Terminal;
import operacion.Sheeper;
import container.Container;
import factura.Factura;
import viaje.Viaje;

public class Exportacion extends Operacion {
	
	private Sheeper sheeper;
    private Terminal tdestino;
    private Terminal tOrigen;

	 public Exportacion(Viaje viaje, Sheeper sheeper, Terminal tOrigen, Terminal tdestino, Container contenedor, LocalDate fecha) {
	        super(viaje,contenedor,fecha);
	        this.sheeper = sheeper;
	        this.tOrigen = tOrigen;
	        this.tdestino = tdestino;
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


}
