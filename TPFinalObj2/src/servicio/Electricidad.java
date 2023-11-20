package servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Electricidad extends Servicio {
	
	private double precioFijoPorkw;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private int cantidadKW;
    
    
    
    public Electricidad(double precioFijoPorkw, LocalDateTime fechaInicio, LocalDateTime fechaFin, int cantidadKW,LocalDate fecha) {
        super(fecha);
        this.precioFijoPorkw = precioFijoPorkw;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadKW = cantidadKW;
    }



    @Override
    public double precio() {
         double precioReturn;
        if(fechaFin == null) {
             precioReturn = (cantidadKW * precioFijoPorkw* ChronoUnit.HOURS.between(fechaInicio, LocalDateTime.now()));
        }else {
            precioReturn = (cantidadKW * ChronoUnit.HOURS.between(fechaInicio, fechaFin));
        }
        return precioReturn;
    }

}
