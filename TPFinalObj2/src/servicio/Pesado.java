package servicio;

import java.time.LocalDate;

public class Pesado extends Servicio {
	private int peso;
    private double precioFijo;
    
    
    
    public Pesado(int peso, double precioFijo,LocalDate fecha) {
        super(fecha);
        this.peso = peso;
        this.precioFijo = precioFijo;
    }


    public int getPeso() {
        return peso;
    }


    @Override
    public double precio() {
        // TODO Auto-generated method stub
        return precioFijo;
    }
} 
