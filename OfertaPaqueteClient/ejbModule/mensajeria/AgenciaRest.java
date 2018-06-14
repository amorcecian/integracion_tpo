package mensajeria;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Session Bean implementation class AgenciaRest
 */
@Stateless
@LocalBean
public class AgenciaRest implements AgenciaRestRemote, AgenciaRestLocal {
	
    Properties prop = new Properties();
    InputStream input = null;

    /**
     * Default constructor. 
     */
    public AgenciaRest() {
        // TODO Auto-generated constructor stub
    }
    
    public void envioBackoffice (String aJson) {
		try {
			
        input = new FileInputStream("config.properties");
        prop.load(input);
        String urlBackOffice = prop.getProperty("BackOfficeURL"); 
    	
		URL url = new URL(urlBackOffice);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestMethod("POST");
	  	urlConnection.setRequestProperty("Content-Type","application/json");
	  	
	 	DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
	 	wr.writeBytes(aJson);
	 	wr.flush();
	 	wr.close();
	 	
	 	
	  	if(urlConnection.getResponseCode() != 200) {
	  		throw new RuntimeException("Error de conexión: " + urlConnection.getResponseCode());
	  	}
	  	
	  	//String response = IOUtils.toString(urlConnection.getInputStream());
	  	//System.out.println("Respuesta: " + response);
	  	
 	
	
		} catch (Exception e) {			
			e.printStackTrace();
		}

	  	
	  	
    	
    }

}
