package mensajeria;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.annotation.Resource;

import javax.jms.*;
/**
 * Session Bean implementation class PortalWebQueue
 */
@Stateless
@LocalBean
public class PortalWebQueue implements PortalWebQueueRemote {

	public PortalWebQueue() {

	}

	@Resource(lookup = "java:/jms/queue/ofertaPaquetes")
	Destination destination;

	@Resource(lookup = "java:/jms/queue/MyConnectionFactory")
	ConnectionFactory connectionFactory;

	public void sendMessage(String messageText) {

		System.out.println(messageText);

		try {
			QueueConnection connection = (QueueConnection) connectionFactory.createConnection("integracion","integracion");

			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage(messageText);
			producer.send(message);

			producer.close();
			session.close();
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
