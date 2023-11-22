package operacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import servicio.Servicio;
import container.Container;
import servicio.Pesado;
import viaje.Viaje;
import container.Container;

public abstract class Operacion {
	
	private List<Servicio> servicios;
    private Viaje viaje;
    private Container container;
	private LocalDate fecha;
    
    
    public Operacion(Viaje Viaje,Container container, LocalDate fecha) {
        super();
        this.servicios = new ArrayList<Servicio>();
        this.container = container;
		this.fecha = fecha;
		new Pesado(container.getPeso(), 1000d, fecha);
    }
    
    public List<Servicio> getServicios() {
        return servicios;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public double precio() {
        return servicios.stream().mapToDouble(S->S.precio()).sum() + costoAdicional();
    }
    
    public void agregarServicio(Servicio servicio) {
    	this.getServicios().add(servicio);
    }
    
    public abstract double costoAdicional(); //template method de consignee y sheeper (precio de servicios)

    public void enviarMailConsignee(String string) {}; //hook method
    public void enviarMailSheeper(String string) {}//hook method

    
    public abstract void enviarFactura() ;
} 

