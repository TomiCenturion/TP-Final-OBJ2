package naviera;

import java.util.List;

import buque.Terminal;
import viaje.Viaje;
import naviera.Circuito;


public class Naviera {
	
	private List<Circuito> circuitos;
    private List<Viaje> viajes;

    public List<Viaje> getViajes() {
        return viajes;
    }

    public List<Circuito> getCircuito(Terminal terminalGestionada) {
        // TODO Auto-generated method stub
        return circuitos.stream().filter(c->c.contieneTerminal(terminalGestionada)).toList();
    }

    public int getMejorTiempoHasta(TerminalGestionada terminalGestionada, Terminal tdestino) {
        //PRECONDICION : EXISTE AL MENOS UN CIRCUITO CON AMBAS TERMINALES.
        //SEGUN BUTTI EL MEJOR TIEMPO ES EL MENOR *
        int buscarCircuitoRandom = circuitos.stream()
                .filter(c->c.contieneTerminal(terminalGestionada) && c.contieneTerminal(tdestino))
                .mapToInt(c -> c.tiempoDesdeHastaEnHoras(terminalGestionada, tdestino))
                .min().getAsInt();
        return buscarCircuitoRandom;
    }

}
