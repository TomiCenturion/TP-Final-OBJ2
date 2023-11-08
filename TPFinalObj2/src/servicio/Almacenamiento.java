package servicio;

public class Almacenamiento extends Servicio {
	
	private int diasDeAlmacenamiento;
    private double precioFijo;
    
    
    
    public Almacenamiento(int diasDeAlmacenamiento, double precioFijo) {
        super();
        this.diasDeAlmacenamiento = diasDeAlmacenamiento;
        this.precioFijo = precioFijo;
    }

    @Override
    public double precio() {
        // TODO Auto-generated method stub
        return precioFijo * diasDeAlmacenamiento; // El costo se lo agrego manualmente ya que no especifica.
    }


}
