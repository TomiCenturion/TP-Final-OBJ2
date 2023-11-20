package operacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import servicio.Servicio;
import tpFinal2023o2.Container;
import tpFinal2023o2.Pesado;
import viaje.Viaje;
import container.Container;

public abstract class Operacion {
	
	private List<Servicio> servicios;
    private Viaje Viaje;
    private Container container;
	private LocalDate fecha;
    
    
    public Operacion(Viaje Viaje,Container container, LocalDate fecha) {
        super();
        this.servicios = new ArrayList<Servicio>();
        this.Viaje = Viaje;
        this.container = container;
		this.fecha = fecha;
		new Pesado(container.getPeso(), 1000d, fecha);
    }
    
    public List<Servicio> getServicios() {
        return servicios;
    }

    public Viaje getViaje() {
        return Viaje;
    }

    public double precio() {
        return servicios.stream().mapToDouble(S->S.precio()).sum() + costoAdicional();
    }
    
    public abstract double costoAdicional(); //template method de consignee y sheeper (precio de servicios)

    public void enviarMailConsignee(String string) {}; //hook method
    public void enviarMailSheeper(String string) {}//hook method

    
    public abstract void enviarFactura() ;
} 

