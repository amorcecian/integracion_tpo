package controlador;

import java.util.ArrayList;

import javax.ejb.Remote;

import dto.AgenciaDTO;
import dto.PaqueteDTO;

@Remote
public interface ControladorFacadeRemote {
	
	public void altaAgencia(AgenciaDTO a);
	
	public ArrayList<AgenciaDTO> recuperarAgencias();
	
	public ArrayList<PaqueteDTO> recuperarPaquetes();

}
