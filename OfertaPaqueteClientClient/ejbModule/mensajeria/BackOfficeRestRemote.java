package mensajeria;

import javax.ejb.Remote;

import dto.AgenciaDTO;

@Remote
public interface BackOfficeRestRemote {
	
	 public void envioAgenciaBackoffice (AgenciaDTO adto);
	 
	 public void Loggear (String accion);
  	
	 public void obtenerServicios();

}
