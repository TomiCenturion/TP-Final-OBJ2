package operacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import buque.Terminal;
import container.Container;
import factura.Factura;
import servicio.Servicio;
import viaje.Viaje;

public class Importacion extends Operacion{

	private Consignee consignee;
    private Terminal terminalOrigen;
    private Terminal terminalLlegada;
    private List <Servicio> servicios;
    private Viaje viaje;
 

    public Importacion( Viaje viaje, Consignee consignee, Terminal terminalOrigen, Terminal terminalLlegada,Container container, LocalDate fecha) {
        super( viaje,container,fecha);
        this.consignee = consignee;
        this.terminalOrigen = terminalOrigen;
        this.terminalLlegada = terminalLlegada;
        this.servicios = new ArrayList <Servicio>();
    }

    @Override
    public void enviarMailConsignee(String mail) {
         consignee.enviarMail(mail + " La fecha es: " + this.getViaje().fechaDeSalidaDe(terminalLlegada));
        
    }

    @Override
    public double costoAdicional() {
        // TODO Auto-generated method stub
        return this.getViaje().precioDesdeHasta(terminalOrigen,terminalLlegada);
    }

    @Override
    public void enviarFactura() {
        this.consignee.enviarFactura(new Factura(this.getServicios(),this.precio()));
    }
    
    @Override
	public List <Servicio> getServicios(){
		return servicios;
	}

	@Override
	public void agregarServicio(Servicio servicio) {
		this.getServicios().add(servicio);
	}
    
	
	@Override
	public Viaje getViaje() {
		return viaje;
	}
	
}
