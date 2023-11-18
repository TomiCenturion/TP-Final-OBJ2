package operacion;
import java.util.ArrayList;
import java.util.List;
import servicio.Servicio;
import viaje.Viaje;

public abstract class Operacion {
	
	private List<Servicio> servicios;
    private Viaje Viaje;
    
    
    public Operacion(Viaje Viaje) {
        super();
        this.servicios = new ArrayList<Servicio>();
        this.Viaje = Viaje;
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

