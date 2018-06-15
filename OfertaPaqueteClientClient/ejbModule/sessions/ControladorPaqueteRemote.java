package sessions;

import java.util.ArrayList;
import javax.ejb.Remote;
import dto.PaqueteDTO;


@Remote
public interface ControladorPaqueteRemote {
	
	public int altaPaquete(PaqueteDTO pdto); 
	
	public ArrayList<PaqueteDTO> recuperarPaquetes();

}
