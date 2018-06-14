package mensajeria;

import javax.ejb.Remote;

@Remote
public interface AgenciaRestRemote {
	
	 public void envioBackoffice (String aJson);

}
