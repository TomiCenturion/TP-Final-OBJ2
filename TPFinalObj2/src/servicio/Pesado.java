package servicio;

import java.time.LocalDate;

public class Pesado extends Servicio {
	private double peso;
    private double precioFijo;
    
    
    
    public Pesado(double peso, double precioFijo,LocalDate fecha) {
        super(fecha);
        this.peso = peso;
        this.precioFijo = precioFijo;
    }


//    public double getPeso() {
//        return peso;
//    }


    @Override
    public double precio() {
        // TODO Auto-generated method stub
        return precioFijo;
    }
} 
