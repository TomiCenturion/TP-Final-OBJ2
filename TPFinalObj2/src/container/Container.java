package container;

public abstract class Container {
	private double ancho;
	private double largo;
	private double altura;
	private double peso;
	
	public Container(double ancho, double largo, double altura, double peso) {
		super();
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
		this.peso = peso;
	}

	public double getAncho() {
		return ancho;
	}

	public double getLargo() {
		return largo;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}
	
	public int getConsumoWts() {
		return 0; //method hook
	}
	
	
	
	
}