package operacion;
import java.time.LocalDate;

import buque.Terminal;
import operacion.Sheeper;
import viaje.Viaje;

public class Exportacion extends Operacion {
	
	private Sheeper sheeper;
    private Terminal tdestino;
    private Terminal tOrigen;
    private LocalDate fechaSalida;

	 public Exportacion(Viaje viaje, Sheeper sheeper, Terminal tOrigen, Terminal tdestino) {
	        super(viaje);
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
		// TODO Auto-generated method s
	}
	
	@Override
    public void enviarMailSheeper(String mail) {
        sheeper.enviarMail(mail);
    }


}
