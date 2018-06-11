package sessions;

import javax.ejb.Local;

@Local
public interface ControladorAgenciaLocal {
	
	public void altaAgencia(String nombre, String direccion);

}
