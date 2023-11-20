package operacion;

import factura.Factura;

public interface Sheeper {
	
	public void enviarMail(String m);
    public void enviarFactura(Factura f);
}
