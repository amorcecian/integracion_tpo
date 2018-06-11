package controlador;

import javax.ejb.Remote;

@Remote
public interface ControladorRemote {
	
	public void altaAgencia(String nombre, String direccion);

}
