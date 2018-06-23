package mensajeria;

import javax.ejb.Remote;

@Remote
public interface PortalWebQueueRemote {
	
	public void sendMessage(String messageText);

}
