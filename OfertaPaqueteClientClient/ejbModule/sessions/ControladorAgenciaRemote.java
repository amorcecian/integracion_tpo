package sessions;

import javax.ejb.Remote;

@Remote
public interface ControladorAgenciaRemote {
	
	public void altaAgencia(String nombre, String direccion);

}
