package controlador;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import dto.AgenciaDTO;
import sessions.ControladorAgenciaRemote;

/**
 * Session Bean implementation class Controlador
 */
@Stateless
public class Controlador implements ControladorRemote {
	
	@EJB
	ControladorAgenciaRemote conAgencia;

	public void altaAgencia(AgenciaDTO agencia) {		
		conAgencia.altaAgencia(agencia.getNombre(),agencia.getDireccion());		
	}


}
