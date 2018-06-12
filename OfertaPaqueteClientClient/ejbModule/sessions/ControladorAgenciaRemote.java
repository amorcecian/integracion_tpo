package sessions;

import java.io.IOException;

import javax.ejb.Remote;

@Remote
public interface ControladorAgenciaRemote {
	
	public int altaAgencia(String nombre, String direccion);

}
