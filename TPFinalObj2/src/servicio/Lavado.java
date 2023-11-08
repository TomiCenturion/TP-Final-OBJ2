package servicio;

public class Lavado extends Servicio {
	
	private double costoFijo;
    private double costoFijoExcedido;
    private int capacidad;
    
    public Lavado(double costoFijo, double costoFijoExcedido, int capacidad) {
        super();
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
