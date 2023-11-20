package servicio;

import java.time.LocalDate;

public class Lavado extends Servicio {
	
	private double costoFijo;
    private double costoFijoExcedido;
    private int capacidad;
	private LocalDate fecha;

    
    public Lavado(double costoFijo, double costoFijoExcedido, int capacidad,LocalDate fecha) {
        super(fecha);
        this.costoFijo = costoFijo;
        this.costoFijoExcedido = costoFijoExcedido;
        this.capacidad = capacidad;
    }

    @Override
    public double precio() {
        double costoReturn;
        // TODO Auto-generated method stub
        if(capacidad > 70) {
            costoReturn = costoFijoExcedido;
        }else {
            costoReturn = costoFijo;
        }
        return costoReturn;
    }

} 
