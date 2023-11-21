package operacion;
import factura.Factura;


public interface Consignee {
	
	public void enviarMail(String s);
    public void enviarFactura(Factura f);

}
