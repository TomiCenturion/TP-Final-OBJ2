package empresaTransportista;

import java.util.List;

public class EmpresaTransportista {
	
	private List<String> camiones;
    private List<String> conductores;
    
    
    public void agregarCamion(String c) {
     camiones.add(c);    
        
    }


    public void agregarConductor(String con) {
        conductores.add(con);
        
    }


    public boolean contieneACamion(String cam) {
        // TODO Auto-generated method stub
        return camiones.contains(cam);
    }


    public boolean contieneAConductor(String con) {
        // TODO Auto-generated method stub
        return conductores.contains(con);
    }

}
