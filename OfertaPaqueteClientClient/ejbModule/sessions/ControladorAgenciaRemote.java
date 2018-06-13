package sessions;

import java.io.IOException;
import dto.AgenciaDTO;
import javax.ejb.Remote;

@Remote
public interface ControladorAgenciaRemote {
	
	public int altaAgencia(AgenciaDTO a);

}
