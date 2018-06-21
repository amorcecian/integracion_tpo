package mensajeria;

import java.util.List;

import javax.ejb.Remote;

import dto.AgenciaDTO;
import dto.TipoServicioDTO;

@Remote
public interface BackOfficeRestRemote {
	
	 public void envioAgenciaBackoffice (AgenciaDTO adto);
	 
	 public void Loggear (int accion);
  	
	 public List<TipoServicioDTO> obtenerServicios();

}
