package container;


public class ReeferC extends Container {
	
	private int consumoWts;

	public ReeferC(double ancho, double largo, double altura, double peso, int consumoWts) {
		super(ancho, largo, altura, peso);
		this.consumoWts = consumoWts;
	}

	public int getConsumoWts() {
		return consumoWts;
	}

	
	
}
