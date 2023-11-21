package naviera;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import buque.Buque;
import buque.GPS;
import buque.Terminal;
import circuito.Circuito;
import container.Container;
import estrategiaMejorCircuito.EstrategiaMejorCircuito;
import filtro.Filtro;
import operacion.Consignee;
import operacion.Exportacion;
import operacion.Importacion;
import turno.TurnoExportacion;
import turno.TurnoImportacion;
import viaje.Viaje;
import operacion.Operacion;
import operacion.Sheeper;
import servicio.Almacenamiento;

public class TerminalGestionada implements Terminal {
	
	private  Map<Buque, List<Operacion>> operaciones;
	private GPS ubicacion;
	private List<Naviera> navieras;
	private EstrategiaMejorCircuito estrategia;
	private List<TurnoExportacion> turnoExportacion;
	private List<TurnoImportacion> turnosImportacion;
	
	

	public TerminalGestionada(EstrategiaMejorCircuito estrategia ,GPS ubicacion) {
		super();
		this.estrategia = estrategia;
		this.operaciones = new HashMap<>();
		this.ubicacion = ubicacion;
		this.navieras = new ArrayList<>();
		this.turnoExportacion = new ArrayList<>();
		this.turnosImportacion = new ArrayList<>();
	}

	
	public Map<Buque, List<Operacion>> getOperaciones() {
		return operaciones;
	}


	@Override
	public GPS getUbicacion() {
		// TODO Auto-generated method stub
		return ubicacion;
	}
	
	public void setEstrategia(EstrategiaMejorCircuito estrategia) {
		this.estrategia = estrategia;
	}
	
	public Circuito mejorCircuito(Terminal t2) {
//		List<Circuito> circuitos = navieras.stream().flatMap(n->n.getCircuito(this));
		List<Circuito> circuitos = navieras.stream().map(n->n.getCircuito(this)).toList().stream().flatMap(List:: stream).collect(Collectors .toList());
		return this.estrategia.mejorCircuito(circuitos, this, t2);
	}
	
 

	public void registrarNaviera(Naviera n) {
		navieras.add(n);
	}
	
	public LocalDate proximaFechaHastaTerminalDestino(Terminal terminalDestino,LocalDate fecha) { //se le pasa una fecha por motivo de testeo
		
				int dias = this.mejorCircuito( terminalDestino).tiempoDesdeHastaEnHoras(this, terminalDestino) / 24 ;
				return fecha.plusDays(dias);
	}
	
	public void exportar(Container container, Sheeper sheeper,String camion, String conductor, Terminal destino, Viaje viaje, LocalDateTime fechaTurno){
		TurnoExportacion nuevoTurnno =	new TurnoExportacion(viaje, sheeper, fechaTurno, destino, container, conductor,  camion);
			this.turnoExportacion.add(nuevoTurnno);
	}
		
	public List<TurnoExportacion> getTurnoExportacion() {
		return turnoExportacion;
	}

	public List<TurnoImportacion> getTurnosImportacion() {
		return turnosImportacion;
	}

	public void entregarCargaTerrestre(String camion, String conductor,Container container, LocalDateTime fechaActual) throws Exception{
		TurnoExportacion turno = this.turnoExportacion.stream().filter(t-> t.verificarCamionConductorYTurnoCorrecto(conductor, camion, fechaActual)).findFirst().orElse(null);
			if(!(turno == null)) {
				
			Exportacion exportacion = new Exportacion(turno.getViaje(),turno.getSheeper(), this, turno.getTerminalLlegada(), container,fechaActual.toLocalDate());
			operaciones.putIfAbsent(turno.getViaje().getBuque(),new ArrayList<Operacion>());
			operaciones.get(turno.getViaje().getBuque()).add(exportacion);
			this.turnoExportacion.remove(turno);
		}else {
			new Exception("El turno no ha sido verificado");
		}
	} 
	
	public void empezarATrabajar(Buque buque) {
		buque.comenzarATrabajar();
	}
	
	public void terminarDeTrabajar(Buque buque) {
		buque.finalizarTrabajo();
	}

//	public int tiempoDeLlegadaDeTGestionadaAOtraTerminal(Naviera n, Terminal tdestino) { //tiempo en horas
//		return n.getMejorTiempoHasta(this, tdestino); 
//	} 
	public int tiempoDeLlegadaDeTGestionadaAOtraTerminal(Terminal tExterna) {
		return this.navieras.stream().mapToInt(m->m.getMejorTiempoHasta(this, tExterna)).min().getAsInt();
	}
	
	
	
	public void importar(Consignee consignee, Terminal terminalOrigen, Viaje viaje, Container container,LocalDate fecha) {
		Importacion importacion = new Importacion(viaje, consignee, terminalOrigen,this, container,fecha);
		
		operaciones.putIfAbsent(viaje.getBuque(),new ArrayList<Operacion>());
		operaciones.get(viaje.getBuque()).add(importacion);
		TurnoImportacion turno = new TurnoImportacion(viaje.fechaDeSalidaDe(this),consignee,importacion);
		turnosImportacion.add(turno);
	}
	
	public LocalDate fechaBuqueHasta(Terminal tdestino) {
		return navieras.stream()
				.flatMap(n-> n.getViajes().stream()) 
				.filter(v -> v.contieneA(this) && v.contieneA(tdestino))
				.map(v -> v.fechaDeSalidaDe(this))
				.min(LocalDate::compareTo).get();
	} 
	
	public List<Viaje> filtrarViajes(Filtro f) {
		List<Viaje> viajes = navieras.stream().flatMap(n-> n.getViajes().stream()).filter(v->v.contieneA(this)).toList(); //lista viajes entera, si no es lista de lista
		return f.filtrar(viajes);
	}

	@Override
	public void enviarMailATodosConsignee(Buque buque) {
		// TODO Auto-generated method stub
		operaciones.get(buque).stream().forEach(o->o.enviarMailConsignee("La carga esta llegando"));		
		
	}

	@Override
	public void enviarMailATodosSheepers(Buque buque) {
		operaciones.get(buque).stream().forEach(b->b.enviarMailSheeper("La carga esta saliendo"));
		
	}
	
	public void enviarFactura(Buque b) {
		this.operaciones.get(b).stream().forEach(o->o.enviarFactura());
	}
	
	public void retirarCarga(String camion, String conductor, ChronoLocalDate fecha) {
		TurnoImportacion turno = turnosImportacion.stream().filter(t->t.verificarTurno(camion,conductor,fecha)).findFirst().orElse(null);
		if(!(turno == null)) {
			Importacion importacion = turno.getImportacion();
			turnosImportacion.remove(turno);
			if(turno.verificarExcedente(fecha) > 0) {//si es mayor a 0 significa que paso mas de una dia
				new Almacenamiento(turno.verificarExcedente(fecha), 1000, (LocalDate)fecha);
				
			}
		}else {
			new Exception("El turno no ha sido verificado");
		}
	}
	
		
	
	public void registrarCamionYConductor(Consignee consignee, String camion, String conductor, LocalDate fecha) throws Exception{
		TurnoImportacion turno = turnosImportacion.stream().filter(t->t.getConsignee() == consignee && t.getHoraDeLlegada() == fecha).findFirst().get();
		if(turno != null) {
			turno.setCamion(camion);
		turno.setConductor(conductor); 
		}else {
			throw new Exception ("No se encontro ningun turno con esa fecha");
		}
		
	}


}
