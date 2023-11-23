package naviera;

import java.util.ArrayList;
import java.util.List;

import buque.Terminal;
import viaje.Viaje;
import circuito.Circuito;

public class Naviera {
	
	private List<Circuito> circuitos;
    private List<Viaje> viajes;
    
    public Naviera() {
		super();
		this.circuitos = new ArrayList<>();
		this.viajes = new ArrayList<>();
	}

    public List<Viaje> getViajes() {
        return viajes;
    }

    
    public List<Circuito> getCircuito(Terminal terminalGestionada) {
        // TODO Auto-generated method stub
        return circuitos.stream().filter(c->c.contieneTerminal(terminalGestionada)).toList();
    }

    public int getMejorTiempoHasta(Terminal terminal, Terminal tdestino) {
		//PRECONDICION : EXISTE AL MENOS UN CIRCUITO CON AMBAS TERMINALES.
		//SEGUN BUTTI EL MEJOR TIEMPO ES EL MENOR *
		int buscarCircuitoRandom = circuitos.stream()
				.filter(c->c.contieneTerminal(terminal) && c.contieneTerminal(tdestino))
				.map(c -> c.tiempoDesdeHastaEnHoras(terminal, tdestino))
				.min(Integer :: compareTo).get();
		return buscarCircuitoRandom;
	} 
    
    public void registrarCircuitos(Circuito c) {
		circuitos.add(c); //Consultado con ayudante 
	}
    
    public void agregarViaje(Viaje viaje) {
    	this.getViajes().add(viaje);
    }

    
    public List <Circuito> getCircuitos(){
    	return this.circuitos;
    }
}
