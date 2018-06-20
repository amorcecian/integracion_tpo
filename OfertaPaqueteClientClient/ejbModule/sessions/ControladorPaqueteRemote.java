package sessions;


import java.util.List;
import javax.ejb.Remote;

import dto.DestinoDTO;
import dto.PaqueteDTO;


@Remote
public interface ControladorPaqueteRemote {
	
	public void altaPaquete(PaqueteDTO pdto); 
	
	public List<PaqueteDTO> recuperarPaquetes();
	
	public List<DestinoDTO> obtenerDestinos();

}
