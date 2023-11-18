package operacion;

import buque.Terminal;
import viaje.Viaje;


public class Importacion extends Operacion{

	private Consignee consignee;
    private Terminal terminalOrigen;
    private Terminal terminalLlegada;


    public Importacion(Viaje viaje, Consignee consignee, Terminal terminalOrigen, Terminal terminalLlegada) {
        super( viaje);
        this.consignee = consignee;
        this.terminalOrigen = terminalOrigen;
        this.terminalLlegada = terminalLlegada;
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
    
	
}
