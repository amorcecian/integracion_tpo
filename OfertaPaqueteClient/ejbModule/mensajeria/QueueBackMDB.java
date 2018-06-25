package mensajeria;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: QueueBack
 */

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
						//java:jboss/exported/jms/queue/colaBack
				propertyName = "destination", 
					propertyValue = "jms/queue/ofertaPaquetes"), 
				@ActivationConfigProperty(
				propertyName = "destinationType", 
					propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(propertyName = "user", 
					propertyValue = "integracion"),  
				@ActivationConfigProperty(propertyName = "password", 
					propertyValue = "integracion"),
				@ActivationConfigProperty(propertyName = "connectionParameters", 
					propertyValue = "host=localhost;port=8080; http-upgrade-enabled=true"),
				@ActivationConfigProperty(propertyName = "connectorClassName",
            		propertyValue = "org.hornetq.core.remoting.impl.netty.NettyConnectorFactory"),
//                @ActivationConfigProperty(propertyName = "jndiParams", 
//                	propertyValue = "java.naming.factory.initial=org.jboss.naming.remote.client.InitialContextFactory;"
//                			+ "java.naming.provider.url=http-remoting://192.168.0.76:8080;"
//                			+ "java.naming.security.principal=integrados;"
//                			+ "java.naming.security.credentials=integrados"),
//				@ActivationConfigProperty(propertyName="useJNDI", 
//					propertyValue = "false")   
		}, 
		mappedName = "jms/queue/ofertaPaquetes")
public class QueueBackMDB implements MessageListener {



    /**
     * Default constructor. 
     */
    public QueueBackMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
  public void onMessage(Message message) {
	  try {
	    String messageText = null;
	    if(message instanceof TextMessage){
	        messageText = ((TextMessage)message).getText();
	    }
	    Logger.getAnonymousLogger().info("Mensaje recibido: " + messageText);
	    System.out.println("Llego el mensaje a la cola =)");
	 
	    
	} catch (Exception e) {
	    Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage(), e);
	}
  
}

}
