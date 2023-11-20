package buque;


public interface Terminal {
	public GPS getUbicacion();
	public void enviarMailATodosConsignee(Buque b);
	public void enviarMailATodosSheepers(Buque b);
}
